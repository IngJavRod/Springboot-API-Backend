package com.thekingtiger.backend.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Integer idAdmin;

    @Column(name = "nom_admin", nullable = false, length = 100)
    private String nomAdmin;

    @Column(name = "correo_admin", nullable = false, length = 100, unique = true)
    private String correoAdmin;

    @Column(name = "password_admin", nullable = false, length = 255)
    private String passwordAdmin;

    public Admin() {
    }

    public Admin(Integer idAdmin, String nomAdmin, String correoAdmin, String passwordAdmin) {
        this.idAdmin = idAdmin;
        this.nomAdmin = nomAdmin;
        this.correoAdmin = correoAdmin;
        this.passwordAdmin = passwordAdmin;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getCorreoAdmin() {
        return correoAdmin;
    }

    public void setCorreoAdmin(String correoAdmin) {
        this.correoAdmin = correoAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Admin admin)) return false;
        return Objects.equals(idAdmin, admin.idAdmin) && Objects.equals(nomAdmin, admin.nomAdmin) && Objects.equals(correoAdmin, admin.correoAdmin) && Objects.equals(passwordAdmin, admin.passwordAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdmin, nomAdmin, correoAdmin, passwordAdmin);
    }
}
