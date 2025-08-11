package com.thekingtiger.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedidos")
    private Integer idPedidos;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    @JsonBackReference(value = "cliente-pedidos")
    private Clientes cliente;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "pagado", nullable = false)
    private Boolean pagado;

    @Column(name = "medio_pago", nullable = false, length = 45)
    private String medioPago;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "pedido-carrito")
    private List<Carrito> carritos;

    public Pedidos(){}

    public Pedidos(Integer idPedidos, Clientes cliente, BigDecimal total, Boolean pagado, String medioPago, List<Carrito> carritos) {
        this.idPedidos = idPedidos;
        this.cliente = cliente;
        this.total = total;
        this.pagado = pagado;
        this.medioPago = medioPago;
        this.carritos = carritos;
    }

    public Integer getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(Integer idPedidos) {
        this.idPedidos = idPedidos;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
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

    public List<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "idPedidos=" + idPedidos +
                ", cliente=" + cliente +
                ", total=" + total +
                ", pagado=" + pagado +
                ", medioPago='" + medioPago + '\'' +
                ", carritos=" + carritos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pedidos pedidos)) return false;
        return Objects.equals(idPedidos, pedidos.idPedidos) && Objects.equals(cliente, pedidos.cliente) && Objects.equals(total, pedidos.total) && Objects.equals(pagado, pedidos.pagado) && Objects.equals(medioPago, pedidos.medioPago) && Objects.equals(carritos, pedidos.carritos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedidos, cliente, total, pagado, medioPago, carritos);
    }
}
