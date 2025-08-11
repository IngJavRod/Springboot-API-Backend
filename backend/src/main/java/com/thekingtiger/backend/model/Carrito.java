package com.thekingtiger.backend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "carrito")
public class Carrito {

    @EmbeddedId
    private CarritoId id;

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "id_pedido")
    @JsonBackReference(value = "pedido-carrito")
    private Pedidos pedido;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    @JsonBackReference(value = "producto-carrito")
    private Productos producto;

    @Column(name = "talla", nullable = false, length = 10)
    private String talla;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public Carrito(){}

    public Carrito(CarritoId id, Pedidos pedido, Productos producto, String talla, Integer cantidad) {
        this.id = id;
        this.pedido = pedido;
        this.producto = producto;
        this.talla = talla;
        this.cantidad = cantidad;
    }

    public CarritoId getId() {
        return id;
    }

    public void setId(CarritoId id) {
        this.id = id;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", pedido=" + pedido +
                ", producto=" + producto +
                ", talla='" + talla + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Carrito carrito)) return false;
        return Objects.equals(id, carrito.id) && Objects.equals(pedido, carrito.pedido) && Objects.equals(producto, carrito.producto) && Objects.equals(talla, carrito.talla) && Objects.equals(cantidad, carrito.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pedido, producto, talla, cantidad);
    }
}
