package com.thekingtiger.backend.repository;

import com.thekingtiger.backend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Query("SELECT u FROM Admin u WHERE u.correoAdmin = ?1")
    Admin findByCorreoAdmin(String correoAdmin);

    Optional<Admin> findByIdAdmin(Integer idAdmin);
}
