package com.thekingtiger.backend.controller;
import com.thekingtiger.backend.model.Clientes;
import com.thekingtiger.backend.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
