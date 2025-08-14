package com.thekingtiger.backend.controller;


import com.thekingtiger.backend.exceptions.AdminNotFoundException;
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

    @GetMapping("/email")
    public ResponseEntity<Admin> getByCorreoAdmin(@RequestParam String correoAdmin){
        Admin adminBycorreoAdmin = adminService.findByCorreoAdmin(correoAdmin);
        if (adminBycorreoAdmin == null){
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(adminBycorreoAdmin, HttpStatus.OK);
    }

    @GetMapping("/admin/{idAdmin}")
    public ResponseEntity<Admin> getByIdAdmin(@PathVariable Integer idAdmin){
        return adminService.findByIdAdmin(idAdmin)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin loginRequest){
        Admin admin = adminService.findByCorreoAdmin(loginRequest.getCorreoAdmin());

        if(admin == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Correo no registrado");

        }
        // Comparar contraseñas
        if (!admin.getPasswordAdmin().equals(loginRequest.getPasswordAdmin())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }

        return ResponseEntity.ok(admin);
    }


    @PutMapping("/update-admin/{idAdmin}")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @PathVariable Integer idAdmin){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(adminService.updateAdmin(admin,idAdmin));
        }catch(AdminNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
