package com.thekingtiger.backend.controller;

import com.thekingtiger.backend.model.Clientes;
import com.thekingtiger.backend.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db/v1/thekingtiger")
public class ClientesController {
    private final ClientesService clientesService;

    @Autowired
    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

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
}
