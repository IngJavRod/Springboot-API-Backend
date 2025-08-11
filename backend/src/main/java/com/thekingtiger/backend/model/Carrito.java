package com.thekingtiger.backend.model;


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
    private Pedidos pedido;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    private Productos producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad = 1;

    public Carrito(){
    }

    public Carrito(CarritoId id, Pedidos pedido, Productos producto, Integer cantidad) {
        this.id = id;
        this.pedido = pedido;
        this.producto = producto;
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
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Carrito carrito)) return false;
        return Objects.equals(id, carrito.id) && Objects.equals(pedido, carrito.pedido) && Objects.equals(producto, carrito.producto) && Objects.equals(cantidad, carrito.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pedido, producto, cantidad);
    }
}
