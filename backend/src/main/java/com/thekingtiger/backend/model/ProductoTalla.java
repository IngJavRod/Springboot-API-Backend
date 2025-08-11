package com.thekingtiger.backend.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "producto_talla")
public class ProductoTalla {

    @EmbeddedId
    private ProductoTallaId id;

    //Relaciones
    @ManyToOne
    @MapsId("idTalla")
    @JoinColumn(name = "id_talla")
    private Tallas talla;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    private Productos producto;

    public ProductoTalla(){
    }

    public ProductoTalla(ProductoTallaId id, Tallas talla, Productos producto) {
        this.id = id;
        this.talla = talla;
        this.producto = producto;
    }

    public ProductoTallaId getId() {
        return id;
    }

    public void setId(ProductoTallaId id) {
        this.id = id;
    }

    public Tallas getTalla() {
        return talla;
    }

    public void setTalla(Tallas talla) {
        this.talla = talla;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ProductoTalla{" +
                "id=" + id +
                ", talla=" + talla +
                ", producto=" + producto +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductoTalla that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(talla, that.talla) && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, talla, producto);
    }
}
