//package com.petmatches.users.util;
//
//import com.petmatches.users.enums.RolName;
//import com.petmatches.users.model.RoleModel;
//import com.petmatches.users.service.RolService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CreateRoles implements CommandLineRunner {
//
//    @Autowired
//    RolService rolService;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        RoleModel rolAdmin = new RoleModel(RolName.ROLE_ADMIN);
//        RoleModel rolUser = new RoleModel(RolName.ROLE_USER);
//
//        rolService.saveRole(rolAdmin);
//        rolService.saveRole(rolUser);
//
//    }
//}
