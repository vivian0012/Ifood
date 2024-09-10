package com.programming.pizza.service;

import com.programming.pizza.entities.Pizza;
import com.programming.pizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    // CREAT
    public Pizza creatObjPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    // READ ALL
    public List<Pizza> readAllPizza(Pizza pizza) {
        return pizzaRepository.findAll();
    }

    // READ BY ID
    public Pizza readByIdPizza (Long pizzaId){
        Pizza obj = pizzaRepository.findById(pizzaId).get();
        return obj;
    }

    // UPDATE
    public Pizza updatePizza(Pizza objNew){
        Long obj = objNew.getIdPizza();
        Pizza objOld = pizzaRepository.getReferenceById(obj);
        DataUpdate(objNew, objOld);
        return pizzaRepository.save(objNew);
    }
    private void DataUpdate(Pizza objNew, Pizza objOld) {
        objNew.setNamePizza(objOld.getNamePizza());
        objNew.setUrlPhotoPizza(objOld.getUrlPhotoPizza());
        objNew.setDescriptionPizza(objOld.getDescriptionPizza());
        objNew.setPricePizza(objOld.getPricePizza());
    }

    // DELETE BY ID
    public void deleteByIdPizza(Long pizzaId){
        pizzaRepository.deleteById(pizzaId);
    }
}

