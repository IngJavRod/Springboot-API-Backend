package com.thekingtiger.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

// Indica que esta clase es una entidad JPA (se mapea a una tabla en la BD)
@Entity
// Define el nombre de la tabla en la base de datos
@Table(name = "clientes")
public class Clientes {

    // Clave primaria de la tabla
    @Id
    // Genera el valor de la clave primaria automáticamente con estrategia de incremento (auto-increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Especifica el nombre de la columna en la tabla
    @Column(name = "id_clientes")
    private Integer idClientes;

    // Nombre del cliente (campo obligatorio, máximo 45 caracteres)
    @Column(name = "nom_cliente", nullable = false, length = 45)
    private String nomCliente;

    // Apellido del cliente (campo obligatorio, máximo 45 caracteres)
    @Column(name = "apellido_cliente", nullable = false, length = 45)
    private String apellidoCliente;

    // Correo del cliente (campo obligatorio, máximo 100 caracteres y único)
    @Column(name = "correo_cliente", nullable = false, length = 100, unique = true)
    private String correoCliente;

    // Dirección del cliente (opcional, máximo 100 caracteres)
    @Column(name = "direccion_cliente", length = 100)
    private String direccionCliente;

    // Teléfono del cliente (campo obligatorio, máximo 30 caracteres)
    @Column(name = "telefono_cliente", nullable = false, length = 30)
    private String telefonoCliente;

    // Contraseña del cliente (campo obligatorio, hasta 255 caracteres, normalmente encriptada)
    @Column(name = "password_cliente", nullable = false, length = 255)
    private String passwordCliente;

    // Relación uno-a-muchos con la tabla Pedidos (un cliente puede tener muchos pedidos)
    // mappedBy indica que el campo "cliente" en la clase Pedidos es el dueño de la relación
    // cascade = CascadeType.ALL → las operaciones sobre cliente se propagan a sus pedidos
    // fetch = FetchType.LAZY → carga diferida, los pedidos no se cargan automáticamente
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "cliente-pedidos")
    private List<Pedidos> pedidos;

    // Relación uno-a-muchos con la tabla Favoritos (un cliente puede tener muchos favoritos)
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "cliente-favoritos")
    private List<Favoritos> favoritos;

    public Clientes(){}

    public Clientes(Integer idClientes, String nomCliente, String apellidoCliente, String correoCliente, String direccionCliente, String telefonoCliente, String passwordCliente, List<Pedidos> pedidos, List<Favoritos> favoritos) {
        this.idClientes = idClientes;
        this.nomCliente = nomCliente;
        this.apellidoCliente = apellidoCliente;
        this.correoCliente = correoCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
        this.passwordCliente = passwordCliente;
        this.pedidos = pedidos;
        this.favoritos = favoritos;
    }

    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer idClientes) {
        this.idClientes = idClientes;
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
                "idClientes=" + idClientes +
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
