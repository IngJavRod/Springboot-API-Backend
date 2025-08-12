package com.thekingtiger.backend.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clientes")
    private Integer idClientes;

    @Column(name = "nom_cliente", length = 45, nullable = false)
    private String nomCliente;

    @Column(name = "apellido_cliente", length = 45, nullable = false)
    private String apellidoCliente;

    @Column(name = "correo_cliente", length = 100, nullable = false, unique = true)
    private String correoCliente;

    @Column(name = "direccion_cliente", length = 100, nullable = false)
    private String direccionCliente;

    @Column(name = "telefono_cliente", length = 30, nullable = false)
    private String telefonoCliente;

    @Column(name = "password_cliente", length = 255, nullable = false)
    private String passwordCliente;

    // Relaciones
    @OneToMany(mappedBy = "cliente")
    private List<Pedidos> pedidos;

    @OneToMany(mappedBy = "cliente")
    private List<Favoritos> favoritos;


    public Clientes() {
    }

    public Clientes(List<Favoritos> favoritos, Integer idClientes, String nomCliente, String apellidoCliente, String correoCliente, String direccionCliente, String telefonoCliente, String passwordCliente, List<Pedidos> pedidos) {
        this.favoritos = favoritos;
        this.idClientes = idClientes;
        this.nomCliente = nomCliente;
        this.apellidoCliente = apellidoCliente;
        this.correoCliente = correoCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
        this.passwordCliente = passwordCliente;
        this.pedidos = pedidos;
    }

    public Integer getIdCliente() {
        return idClientes;
    }

    public void setIdCliente(Integer idClientes) {
        this.idClientes = this.idClientes;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getPasswordCliente() {
        return passwordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }

    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Favoritos> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<Favoritos> favoritos) {
        this.favoritos = favoritos;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "idCliente=" + idClientes +
                ", nomCliente='" + nomCliente + '\'' +
                ", apellidoCliente='" + apellidoCliente + '\'' +
                ", correoCliente='" + correoCliente + '\'' +
                ", direccionCliente='" + direccionCliente + '\'' +
                ", telefonoCliente='" + telefonoCliente + '\'' +
                ", passwordCliente='" + passwordCliente + '\'' +
                ", pedidos=" + pedidos +
                ", favoritos=" + favoritos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Clientes clientes)) return false;
        return Objects.equals(idClientes, clientes.idClientes) && Objects.equals(nomCliente, clientes.nomCliente) && Objects.equals(apellidoCliente, clientes.apellidoCliente) && Objects.equals(correoCliente, clientes.correoCliente) && Objects.equals(direccionCliente, clientes.direccionCliente) && Objects.equals(telefonoCliente, clientes.telefonoCliente) && Objects.equals(passwordCliente, clientes.passwordCliente) && Objects.equals(pedidos, clientes.pedidos) && Objects.equals(favoritos, clientes.favoritos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClientes, nomCliente, apellidoCliente, correoCliente, direccionCliente, telefonoCliente, passwordCliente, pedidos, favoritos);
    }
}