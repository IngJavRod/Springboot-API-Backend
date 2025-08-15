package com.thekingtiger.backend.exceptions;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(Integer idProductos ) {
    super("Producto no existe");
  }
}
