package com.thekingtiger.backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedidos")
    private Integer idPedidos;

    @Column(name = "total", precision = 12, scale = 2, nullable = false)
    private BigDecimal total;

    @Column(name = "pagado", nullable = false)
    private Boolean pagado;

    @Column(name = "medio_pago", length = 45, nullable = false)
    private String medioPago;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Clientes cliente;

    @OneToMany(mappedBy = "pedido")
    private List<Carrito> carrito;

    public Pedidos (){
    }

    public Pedidos(Integer idPedidos, BigDecimal total, Boolean pagado, String medioPago, Clientes cliente, List<Carrito> carrito) {
        this.idPedidos = idPedidos;
        this.total = total;
        this.pagado = pagado;
        this.medioPago = medioPago;
        this.cliente = cliente;
        this.carrito = carrito;
    }

    public Integer getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(Integer idPedidos) {
        this.idPedidos = idPedidos;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<Carrito> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Carrito> carrito) {
        this.carrito = carrito;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "idPedidos=" + idPedidos +
                ", total=" + total +
                ", pagado=" + pagado +
                ", medioPago='" + medioPago + '\'' +
                ", cliente=" + cliente +
                ", carrito=" + carrito +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pedidos pedidos)) return false;
        return Objects.equals(idPedidos, pedidos.idPedidos) && Objects.equals(total, pedidos.total) && Objects.equals(pagado, pedidos.pagado) && Objects.equals(medioPago, pedidos.medioPago) && Objects.equals(cliente, pedidos.cliente) && Objects.equals(carrito, pedidos.carrito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedidos, total, pagado, medioPago, cliente, carrito);
    }
}
