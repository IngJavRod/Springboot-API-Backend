package com.thekingtiger.backend.controller;


import com.thekingtiger.backend.model.Admin;
import com.thekingtiger.backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db/v1/thekingtiger")
@CrossOrigin(origins = "*")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admins")
    public List<Admin> getAdmins(){ return adminService.getAdmins();}

    @PostMapping("/agregar-admin")
    public ResponseEntity<Admin> addAdmin (@RequestBody Admin newAdmin){
        Admin emailAdmin = adminService.findByCorreoAdmin(newAdmin.getCorreoAdmin());
        if (emailAdmin != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addAdmin(newAdmin));

    }
}
