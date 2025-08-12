package com.thekingtiger.backend.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavoritosId implements Serializable {
    private Integer idClientes;
    private Integer idProducto;

    public FavoritosId() {
    }

    public FavoritosId(Integer idClientes, Integer idProducto) {
        this.idClientes = idClientes;
        this.idProducto = idProducto;
    }

    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "FavoritosId{" +
                "idClientes=" + idClientes +
                ", idProducto=" + idProducto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FavoritosId that)) return false;
        return Objects.equals(idClientes, that.idClientes) && Objects.equals(idProducto, that.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClientes, idProducto);
    }
}

