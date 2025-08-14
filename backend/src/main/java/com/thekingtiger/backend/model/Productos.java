package com.thekingtiger.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_productos")
    private Integer idProductos;

    @Column(name = "nom_prod", nullable = false, length = 100)
    private String nomProd;

    @Column(name = "imagenes", columnDefinition = "TEXT")
    private String imagenes;

    @Column(name = "descripcion", columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    @Column(name = "chica", nullable = false)
    private Integer chica;

    @Column(name = "mediana", nullable = false)
    private Integer mediana;

    @Column(name = "grande", nullable = false)
    private Integer grande;

    @Column(name = "unitalla", nullable = false)
    private Integer unitalla;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @Column(name = "categoria", nullable = false, length = 45)
    private String categoria;

    @Column(name = "descuento")
    private Integer descuento;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "producto-carrito")
    private List<Carrito> carritos;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "producto-favoritos")
    private List<Favoritos> favoritos;

    public Productos(){}

    public Productos(Integer idProductos, String nomProd, String imagenes, String descripcion, Integer chica, Integer mediana, Integer grande, Integer unitalla, BigDecimal precio, String categoria, Integer descuento, List<Carrito> carritos, List<Favoritos> favoritos) {
        this.idProductos = idProductos;
        this.nomProd = nomProd;
        this.imagenes = imagenes;
        this.descripcion = descripcion;
        this.chica = chica;
        this.mediana = mediana;
        this.grande = grande;
        this.unitalla = unitalla;
        this.precio = precio;
        this.categoria = categoria;
        this.descuento = descuento;
        this.carritos = carritos;
        this.favoritos = favoritos;
    }

    public Integer getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Integer idProductos) {
        this.idProductos = idProductos;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getChica() {
        return chica;
    }

    public void setChica(Integer chica) {
        this.chica = chica;
    }

    public Integer getMediana() {
        return mediana;
    }

    public void setMediana(Integer mediana) {
        this.mediana = mediana;
    }

    public Integer getGrande() {
        return grande;
    }

    public void setGrande(Integer grande) {
        this.grande = grande;
    }

    public Integer getUnitalla() {
        return unitalla;
    }

    public void setUnitalla(Integer unitalla) {
        this.unitalla = unitalla;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public List<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
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
                ", nomProd='" + nomProd + '\'' +
                ", imagenes='" + imagenes + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", chica=" + chica +
                ", mediana=" + mediana +
                ", grande=" + grande +
                ", unitalla=" + unitalla +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", descuento=" + descuento +
                ", carritos=" + carritos +
                ", favoritos=" + favoritos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Productos productos)) return false;
        return Objects.equals(idProductos, productos.idProductos) && Objects.equals(nomProd, productos.nomProd) && Objects.equals(imagenes, productos.imagenes) && Objects.equals(descripcion, productos.descripcion) && Objects.equals(chica, productos.chica) && Objects.equals(mediana, productos.mediana) && Objects.equals(grande, productos.grande) && Objects.equals(unitalla, productos.unitalla) && Objects.equals(precio, productos.precio) && Objects.equals(categoria, productos.categoria) && Objects.equals(descuento, productos.descuento) && Objects.equals(carritos, productos.carritos) && Objects.equals(favoritos, productos.favoritos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProductos, nomProd, imagenes, descripcion, chica, mediana, grande, unitalla, precio, categoria, descuento, carritos, favoritos);
    }
}
