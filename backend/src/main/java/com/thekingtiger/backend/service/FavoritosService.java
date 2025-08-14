package com.thekingtiger.backend.service;

import com.thekingtiger.backend.model.Favoritos;
import com.thekingtiger.backend.repository.FavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritosService {

    @Autowired
    private FavoritosRepository favoritosRepository;

    public List<Favoritos> obtenerFavoritosPorCliente(Integer idCliente) {
        return favoritosRepository.findById_IdCliente(idCliente);
    }
}
