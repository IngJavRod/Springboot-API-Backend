package com.thekingtiger.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "favoritos")
public class Favoritos {

    @EmbeddedId
    private FavoritosId id;

    @ManyToOne
    @MapsId("idCliente")
    @JoinColumn(name = "id_cliente")
    @JsonBackReference(value = "cliente-favoritos")
    private Clientes cliente;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    @JsonBackReference(value = "producto-favoritos")
    private Productos producto;

    public Favoritos(){}

    public Favoritos(FavoritosId id, Clientes cliente, Productos producto) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
    }

    public FavoritosId getId() {
        return id;
    }

    public void setId(FavoritosId id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Favoritos{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", producto=" + producto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Favoritos favoritos)) return false;
        return Objects.equals(id, favoritos.id) && Objects.equals(cliente, favoritos.cliente) && Objects.equals(producto, favoritos.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, producto);
    }
}
