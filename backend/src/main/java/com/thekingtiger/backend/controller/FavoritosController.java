package com.thekingtiger.backend.controller;

import com.thekingtiger.backend.model.Favoritos;
import com.thekingtiger.backend.service.FavoritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
@CrossOrigin(origins = "*")
public class FavoritosController {

    @Autowired
    private FavoritosService favoritosService;

    @GetMapping("/cliente/{idCliente}")
    public List<Favoritos> obtenerFavoritosPorCliente(@PathVariable Integer idCliente){
        return favoritosService.obtenerFavoritosPorCliente(idCliente);
    }
}
