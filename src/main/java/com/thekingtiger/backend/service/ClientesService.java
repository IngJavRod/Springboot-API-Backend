package com.thekingtiger.backend.service;


import com.thekingtiger.backend.model.Clientes;
import com.thekingtiger.backend.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesService {
    private final ClientesRepository clientesRepository;

    @Autowired
    public ClientesService(ClientesRepository clientesRepository){this.clientesRepository = clientesRepository;}

    public List<Clientes> getClientes(){
        return clientesRepository.findAll();
    }
}
