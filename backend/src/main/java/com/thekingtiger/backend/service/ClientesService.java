package com.thekingtiger.backend.service;


import com.thekingtiger.backend.exceptions.ClienteNotFoundException;
import com.thekingtiger.backend.model.Clientes;
import com.thekingtiger.backend.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {
    private final ClientesRepository clientesRepository;

    @Autowired
    public ClientesService(ClientesRepository clientesRepository){this.clientesRepository = clientesRepository;}

    //Metodo para recuperar todos los clientes
    public List<Clientes> getClientes(){
        return clientesRepository.findAll();
    }

    //Metodo para crear un nuevo cliente
    public Clientes addCliente(Clientes newClient){
        return clientesRepository.save(newClient);
    }

    // Metodo para recuperar a Cliente por email
    public Clientes findByCorreoCliente(String correoCliente) {
        return clientesRepository.findByCorreoCliente(correoCliente);
    }

    public Optional<Clientes> findByIdClientes(Integer idClientes){
        return clientesRepository.findByIdClientes(idClientes);
    }

    // Metodo para actualizar un Cliente
    public Clientes updateClientes(Clientes clientes, Integer idClientes){
        return clientesRepository.findByIdClientes(idClientes)
                .map(clientesMap -> {
                    clientesMap.setNomCliente(clientes.getNomCliente());
                    clientesMap.setApellidoCliente(clientes.getApellidoCliente());
                    clientesMap.setTelefonoCliente(clientes.getTelefonoCliente());
                    clientesMap.setDireccionCliente(clientes.getDireccionCliente());
                    return clientesRepository.save(clientesMap);
                })
                .orElseThrow(() -> new ClienteNotFoundException(idClientes));
    }


}
