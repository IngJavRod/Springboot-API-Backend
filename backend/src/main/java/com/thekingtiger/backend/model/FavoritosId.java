package com.thekingtiger.backend.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavoritosId implements Serializable {
    private Integer idCliente;
    private Integer idProducto;

    public FavoritosId() {}

    public FavoritosId(Integer idCliente, Integer idProducto) {
        this.idCliente = idCliente;
        this.idProducto = idProducto;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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
                "idCliente=" + idCliente +
                ", idProducto=" + idProducto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FavoritosId that)) return false;
        return Objects.equals(idCliente, that.idCliente) && Objects.equals(idProducto, that.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, idProducto);
    }
}

