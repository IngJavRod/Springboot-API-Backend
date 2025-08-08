package com.thekingtiger.backend.repository;

import com.thekingtiger.backend.model.Clientes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.ListCrudRepository;


@Repository
public interface UsuarioRepository extends JpaRepository<Clientes, Integer> {

}
