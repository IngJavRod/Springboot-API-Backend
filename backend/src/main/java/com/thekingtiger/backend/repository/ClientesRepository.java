package com.thekingtiger.backend.repository;

import com.thekingtiger.backend.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

    //Buscar el cliente por Correo
    @Query("SELECT u FROM Clientes u WHERE u.correoCliente = ?1")
    Clientes findByCorreoCliente(String correoCliente);

    Optional<Clientes> findByIdClientes(Integer idClientes);
}
