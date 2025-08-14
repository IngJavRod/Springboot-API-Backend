package com.thekingtiger.backend.controller;


import com.thekingtiger.backend.model.Productos;
import com.thekingtiger.backend.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db/v1/thekingtiger")
@CrossOrigin(origins = "*")
public class ProductosController {
    private final ProductosService productosService;

    @Autowired
    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping("/productos")
    public List<Productos> getProductos(){return productosService.getProductos();}


    //Mapear Crear Producto
    @PostMapping("/agregar-producto")
    public ResponseEntity<Productos> createProducto(@RequestBody Productos productos){
        Productos createProducto = productosService.createProducto(productos);
        return ResponseEntity.ok(createProducto);
    }

    // Buscar producto por id
    @GetMapping("/productos/{idProductos}")
    public ResponseEntity<Productos> getProductoById(@PathVariable Integer idProductos){
        Productos productos = productosService.getProductosById(idProductos);
        if (productos != null){
            return ResponseEntity.ok(productos);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
