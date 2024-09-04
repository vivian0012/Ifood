package com.programming.pizza.controller;


import com.programming.pizza.entities.LoginRequest;
import com.programming.pizza.entities.User;
import com.programming.pizza.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
public class userController {

    @Autowired
    private ServiceUser serviceUser;

    // Creat the first User!
    @PostMapping("creatFirstUser")
    public ResponseEntity<User> creatO(@RequestBody User user) {
        User obj = serviceUser.creatObjEmail(user);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("creatUser")
    public ResponseEntity<?> creat(@RequestBody User user) {
        boolean obj = serviceUser.creatUser(user);
        if (obj) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
    }

    // Take the body from FrontEnd.
    @PostMapping("login")
    public ResponseEntity<?> loginAuth(@RequestBody LoginRequest obj) {
        boolean booleanUser = serviceUser.authUser(obj.getUserEmail(), obj.getUserPassword());
        if (booleanUser) {
            return ResponseEntity.ok().body(booleanUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
    }

}
