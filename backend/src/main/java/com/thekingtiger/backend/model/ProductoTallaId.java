package com.thekingtiger.backend.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductoTallaId implements Serializable {
    private Integer idTalla;
    private Integer idProducto;

    public ProductoTallaId(){
    }

    public ProductoTallaId(Integer idTalla, Integer idProducto) {
        this.idTalla = idTalla;
        this.idProducto = idProducto;
    }

    public Integer getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Integer idTalla) {
        this.idTalla = idTalla;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "ProductoTallaId{" +
                "idTalla=" + idTalla +
                ", idProducto=" + idProducto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductoTallaId that)) return false;
        return Objects.equals(idTalla, that.idTalla) && Objects.equals(idProducto, that.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTalla, idProducto);
    }
}
