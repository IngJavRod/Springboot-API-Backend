package com.thekingtiger.backend.repository;


import com.thekingtiger.backend.model.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritosRepository extends JpaRepository<Favoritos, Integer>{
    List<Favoritos> findById_IdCliente(Integer idCliente);

}
