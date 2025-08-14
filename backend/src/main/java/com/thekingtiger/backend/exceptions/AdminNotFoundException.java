package com.thekingtiger.backend.exceptions;

public class AdminNotFoundException extends RuntimeException{
    public AdminNotFoundException(Integer idAdmin) { super("No se encuentra el admin con el id " + idAdmin);;
    }
}
