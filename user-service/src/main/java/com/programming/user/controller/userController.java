package com.programming.user.controller;


import com.programming.user.entities.LoginRequest;
import com.programming.user.entities.User;
import com.programming.user.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class userController {

    @Autowired
    private ServiceUser serviceUser;

    @GetMapping("readAll")
    public ResponseEntity<List<User>> readAll () {
        List<User> teste = serviceUser.readAll();
        return ResponseEntity.ok().body(teste);
    }

    @PostMapping("creat")
    public ResponseEntity<User> creatO(@RequestBody User user) {
        User obj = serviceUser.creatObjEmail(user);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("creatUser")
    public ResponseEntity<?> creat(@RequestBody User user) {
        boolean obj = serviceUser.creatUser(user);
        if (obj) {
            User tesa = user;
            return ResponseEntity.ok().body(tesa);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
    }

    @PostMapping("login") // Generic de - Pode ser qualquer coisa
    public ResponseEntity<?> loginAuth(@RequestBody LoginRequest obj) {
        boolean booleanUser = serviceUser.authUser(obj.getUserName(), obj.getUserPassword());
        if (booleanUser) {
            return ResponseEntity.ok().body(booleanUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
    }

    @DeleteMapping("delete/{idUser}")
    public void deleteUser(@PathVariable Long idUser){

        serviceUser.deleteById(idUser);
    }
}
