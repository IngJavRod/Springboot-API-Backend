package com.thekingtiger.backend.service;


import com.thekingtiger.backend.exceptions.AdminNotFoundException;
import com.thekingtiger.backend.model.Admin;
import com.thekingtiger.backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }

    public Admin addAdmin(Admin newAdmin){
        return adminRepository.save(newAdmin);
    }

    public Admin findByCorreoAdmin(String correoAdmin){
        return adminRepository.findByCorreoAdmin(correoAdmin);
    }

    public Optional<Admin> findByIdAdmin(Integer idAdmin){
        return adminRepository.findByIdAdmin(idAdmin);
    }

    public Admin updateAdmin(Admin admin, Integer idAdmin){
        return adminRepository.findByIdAdmin(idAdmin)
                .map(adminMap -> {
                    adminMap.setNomAdmin(admin.getNomAdmin());
                    adminMap.setCorreoAdmin(admin.getCorreoAdmin());
                    return adminRepository.save(adminMap);
                })
                .orElseThrow(() -> new AdminNotFoundException(idAdmin));

    }
}
