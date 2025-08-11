package com.thekingtiger.backend.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tallas")
public class Tallas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_talla")
    private Integer idTalla;

    @Column(name = "nom_talla", length = 10, nullable = false)
    private String nomTalla;

    @OneToMany(mappedBy = "talla")
    private List<ProductoTalla> productoTallas;


    public Tallas(){
    }

    public Tallas(Integer idTalla, String nomTalla, List<ProductoTalla> productoTallas) {
        this.idTalla = idTalla;
        this.nomTalla = nomTalla;
        this.productoTallas = productoTallas;
    }

    public Integer getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Integer idTalla) {
        this.idTalla = idTalla;
    }

    public String getNomTalla() {
        return nomTalla;
    }

    public void setNomTalla(String nomTalla) {
        this.nomTalla = nomTalla;
    }

    public List<ProductoTalla> getProductoTallas() {
        return productoTallas;
    }

    public void setProductoTallas(List<ProductoTalla> productoTallas) {
        this.productoTallas = productoTallas;
    }

    @Override
    public String toString() {
        return "Tallas{" +
                "idTalla=" + idTalla +
                ", nomTalla='" + nomTalla + '\'' +
                ", productoTallas=" + productoTallas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tallas tallas)) return false;
        return Objects.equals(idTalla, tallas.idTalla) && Objects.equals(nomTalla, tallas.nomTalla) && Objects.equals(productoTallas, tallas.productoTallas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTalla, nomTalla, productoTallas);
    }
}
