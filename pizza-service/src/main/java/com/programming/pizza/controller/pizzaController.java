package com.programming.pizza.controller;

import com.programming.pizza.entities.Pizza;
import com.programming.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
public class pizzaController {

    @Autowired
    private PizzaService pizzaService;

    // CREAT
    @PostMapping("creatPizza")
    public ResponseEntity<Pizza> creatPizzaObj(@RequestBody Pizza obj) {
        Pizza objPizza = pizzaService.creatObjPizza(obj);
        return ResponseEntity.ok().body(objPizza);
    }

    // READ ALL
    @GetMapping("readAllPizza")
    public ResponseEntity<List<Pizza>> readAllPizza(Pizza obj) {
        List<Pizza> pizzaAllList = pizzaService.readAllPizza(obj);
        return ResponseEntity.ok().body(pizzaAllList);
    }
}
