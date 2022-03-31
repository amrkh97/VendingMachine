package com.demo.vm.controller;

import com.demo.vm.model.RoleModel;
import com.demo.vm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/role")
    public ResponseEntity<List<RoleModel>> getAllRoles(){
        return ResponseEntity.ok().body(roleService.getAllRoles());
    }

    @PostMapping("/role")
    public ResponseEntity<RoleModel> addRole(@RequestBody RoleModel model){
        return ResponseEntity.ok().body(roleService.addRole(model));
    }

    @PutMapping("/role")
    public ResponseEntity<RoleModel> editRole(@RequestBody RoleModel model){
        return ResponseEntity.ok().body(roleService.editRole(model));
    }
}
