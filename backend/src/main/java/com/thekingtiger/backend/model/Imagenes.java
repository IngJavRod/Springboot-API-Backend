package com.thekingtiger.backend.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "imagenes")
public class Imagenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Integer idImagen;

    @Column(name = "ruta_imagen", length = 255, nullable = false)
    private String rutaImagen;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Productos producto;

    public Imagenes (){
    }

    public Imagenes(Integer idImagen, String rutaImagen, Productos producto) {
        this.idImagen = idImagen;
        this.rutaImagen = rutaImagen;
        this.producto = producto;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Imagenes imagenes)) return false;
        return Objects.equals(idImagen, imagenes.idImagen) && Objects.equals(rutaImagen, imagenes.rutaImagen) && Objects.equals(producto, imagenes.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idImagen, rutaImagen, producto);
    }
}
