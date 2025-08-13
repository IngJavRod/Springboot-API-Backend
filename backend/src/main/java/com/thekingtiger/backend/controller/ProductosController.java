package com.thekingtiger.backend.controller;


import com.thekingtiger.backend.model.Productos;
import com.thekingtiger.backend.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/db/v1/thekingtiger")
public class ProductosController {
    private final ProductosService productosService;

    @Autowired
    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping("/productos")
    public List<Productos> getProductos(){return productosService.getProductos();}


}
