package com.thekingtiger.backend.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CarritoId implements Serializable {
    private Integer idPedido;
    private Integer idProducto;

    public CarritoId(){
    }

    public CarritoId(Integer idPedido, Integer idProducto) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "CarritoId{" +
                "idPedido=" + idPedido +
                ", idProducto=" + idProducto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CarritoId carritoId)) return false;
        return Objects.equals(idPedido, carritoId.idPedido) && Objects.equals(idProducto, carritoId.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, idProducto);
    }
}
