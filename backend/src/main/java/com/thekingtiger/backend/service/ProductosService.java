package com.thekingtiger.backend.service;


import com.thekingtiger.backend.model.Productos;
import com.thekingtiger.backend.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {
    private final ProductosRepository productosRepository;

    @Autowired
    public ProductosService(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    // Recuperar todos los productos
    public List<Productos> getProductos(){return productosRepository.findAll();}


}
