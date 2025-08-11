package com.thekingtiger.backend.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nom_categoria", length = 45, nullable = false)
    private String nomCategoria;

    @OneToMany(mappedBy = "idCategoria")
    private List<Productos> productos;

    public Categoria(){
    }

    public Categoria(Integer idCategoria, String nomCategoria, List<Productos> productos) {
        this.idCategoria = idCategoria;
        this.nomCategoria = nomCategoria;
        this.productos = productos;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public void setNomCategoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nomCategoria='" + nomCategoria + '\'' +
                ", productos=" + productos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Categoria categoria)) return false;
        return Objects.equals(idCategoria, categoria.idCategoria) && Objects.equals(nomCategoria, categoria.nomCategoria) && Objects.equals(productos, categoria.productos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, nomCategoria, productos);
    }
}
