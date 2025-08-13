package com.thekingtiger.backend.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_productos")
    private Integer idProductos;

    @Column(name = "nom_prod", length = 100, nullable = false)
    private String nombreProducto;

    @Column(name = "precio", precision = 10, scale = 2, nullable = false)
    private Integer precioProducto;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Integer descuento;

    @Column(length = 100, nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Integer cant;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria idCategoria;

    @OneToMany(mappedBy = "producto")
    private List<ProductoTalla> productoTallas;

    @OneToMany(mappedBy = "producto")
    private List<Imagenes> imagenes;

    @OneToMany(mappedBy = "producto")
    private List<Carrito> carrito;

    @OneToMany(mappedBy = "producto")
    private List<Favoritos> favoritos;

    //Generamos un constructor vacio para JPA, clase de Java POJO
    public Productos() {

    }

    public Productos(Integer idProductos, String nombreProducto, Integer precioProducto, Integer stock, Integer descuento, String descripcion, Integer cant, Categoria idCategoria, List<ProductoTalla> productoTallas, List<Imagenes> imagenes, List<Carrito> carrito, List<Favoritos> favoritos) {
        this.idProductos = idProductos;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.stock = stock;
        this.descuento = descuento;
        this.descripcion = descripcion;
        this.cant = cant;
        this.idCategoria = idCategoria;
        this.productoTallas = productoTallas;
        this.imagenes = imagenes;
        this.carrito = carrito;
        this.favoritos = favoritos;
    }

    public Integer getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Integer idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Integer precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<ProductoTalla> getProductoTallas() {
        return productoTallas;
    }

    public void setProductoTallas(List<ProductoTalla> productoTallas) {
        this.productoTallas = productoTallas;
    }

    public List<Imagenes> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagenes> imagenes) {
        this.imagenes = imagenes;
    }

    public List<Carrito> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Carrito> carrito) {
        this.carrito = carrito;
    }

    public List<Favoritos> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<Favoritos> favoritos) {
        this.favoritos = favoritos;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "idProductos=" + idProductos +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioProducto=" + precioProducto +
                ", stock=" + stock +
                ", descuento=" + descuento +
                ", descripcion='" + descripcion + '\'' +
                ", cant=" + cant +
                ", idCategoria=" + idCategoria +
                ", productoTallas=" + productoTallas +
                ", imagenes=" + imagenes +
                ", carrito=" + carrito +
                ", favoritos=" + favoritos +
                '}';
    }


}
