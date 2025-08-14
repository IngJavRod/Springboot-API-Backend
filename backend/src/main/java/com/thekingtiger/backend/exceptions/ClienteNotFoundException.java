package com.thekingtiger.backend.exceptions;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(Integer idCliente) {
        super("No se encuentra el cliente con el id " + idCliente);
    }
}
