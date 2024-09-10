package com.programming.pizza.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_pizza")
public class Pizza implements Serializable {

    public final static long serialUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPizza;
    private String urlPhotoPizza;
    private String namePizza;
    private String descriptionPizza;
    private Long pricePizza;

    public Pizza(){}

    public Pizza(Long idPizza, String urlPhotoPizza, String namePizza, String descriptionPizza, Long pricePizza) {
        this.idPizza = idPizza;
        this.urlPhotoPizza = urlPhotoPizza;
        this.namePizza = namePizza;
        this.descriptionPizza = descriptionPizza;
        this.pricePizza = pricePizza;
    }

    public Long getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(Long idPizza) {
        this.idPizza = idPizza;
    }

    public String getUrlPhotoPizza() {
        return urlPhotoPizza;
    }

    public void setUrlPhotoPizza(String urlPhotoPizza) {
        this.urlPhotoPizza = urlPhotoPizza;
    }

    public String getNamePizza() {
        return namePizza;
    }

    public void setNamePizza(String namePizza) {
        this.namePizza = namePizza;
    }

    public String getDescriptionPizza() {
        return descriptionPizza;
    }

    public void setDescriptionPizza(String descriptionPizza) {
        this.descriptionPizza = descriptionPizza;
    }

    public Long getPricePizza() {
        return pricePizza;
    }

    public void setPricePizza(Long pricePizza) {
        this.pricePizza = pricePizza;
    }
}



