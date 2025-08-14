package com.thekingtiger.backend.controller;

import com.thekingtiger.backend.exceptions.ClienteNotFoundException;
import com.thekingtiger.backend.model.Clientes;
import com.thekingtiger.backend.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db/v1/thekingtiger")
@CrossOrigin(origins = "*")
public class ClientesController {
    private final ClientesService clientesService;

    @Autowired
    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    //Mapear los clientes
    @GetMapping("/clientes")
    public List<Clientes> getClientes(){return clientesService.getClientes();}

    // Mapear createClient
    @PostMapping("/agregar-cliente")
    public ResponseEntity<Clientes> addCliente(@RequestBody Clientes newCliente){
        Clientes emailCliente = clientesService.findByCorreoCliente(newCliente.getCorreoCliente());
        if (emailCliente != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(clientesService.addCliente(newCliente));
    }

    //Mapear ClienteId
    @GetMapping("/email")
    public ResponseEntity<Clientes> getByCorreoCliente(@RequestParam String correoCliente){
        Clientes clienteBycorreoCliente = clientesService.findByCorreoCliente(correoCliente);
        if (clienteBycorreoCliente == null){
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(clienteBycorreoCliente, HttpStatus.OK);
    }

    @GetMapping("/cliente/{idClientes}")
    public ResponseEntity<Clientes> getByIdClientes(@PathVariable Integer idClientes){
        return clientesService.findByIdClientes(idClientes)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Maepar inicio de sesion
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Clientes loginRequest){
        Clientes clientes = clientesService.findByCorreoCliente(loginRequest.getCorreoCliente());

        if(clientes == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Correo no registrado");

        }
        // Comparar contraseñas
        if (!clientes.getPasswordCliente().equals(loginRequest.getPasswordCliente())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }

        return ResponseEntity.ok(clientes);
    }

    // Mapear updateCliente
    @PutMapping("/update-cliente/{idClientes}")
    public ResponseEntity<Clientes> updateClientes(@RequestBody Clientes clientes, @PathVariable Integer idClientes){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(clientesService.updateClientes(clientes,idClientes));
        }catch(ClienteNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
