package com.demo.vm.controller;

import com.demo.vm.model.MoneyModel;
import com.demo.vm.model.UserModel;
import com.demo.vm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAll());
    }

    @PostMapping("/user")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel user){
        return ResponseEntity.ok().body(userService.addUser(user));
    }

    @PutMapping("/user")
    public ResponseEntity<UserModel> editUser(@RequestBody UserModel user){
        return ResponseEntity.ok().body(userService.editUser(user));
    }


    @GetMapping("/user/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.deleteUser(id));
    }

    @PostMapping("/deposit")
    public ResponseEntity<UserModel> depositMoney(@RequestBody MoneyModel model) throws Exception {
        UserModel userModel = userService.depositMoney(model);
        if(userModel == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else
            return ResponseEntity.ok().body(userModel);
    }

    @GetMapping("/reset/{id}")
    public ResponseEntity<String> resetDeposit(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok().body(userService.resetDeposit(id));
    }
}

