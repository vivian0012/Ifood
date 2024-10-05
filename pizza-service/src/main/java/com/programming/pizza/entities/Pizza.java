package com.programming.pizza.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_pizza")
public class Pizza implements Serializable {

    public final static long serialUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPizza;
    private String pathPizza;
    private String namePizza;
    private String descriptionPizza;
    private Double pricePizza;

    public Pizza(){}

    public Pizza(Long idPizza, String pathPizza, String namePizza, String descriptionPizza, Double pricePizza) {
        this.idPizza = idPizza;
        this.pathPizza = pathPizza;
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

    public String getPathPizza() {
        return pathPizza;
    }

    public void setPathPizza(String pathPizza) {
        this.pathPizza = pathPizza;
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

    public Double getPricePizza() {
        return pricePizza;
    }

    public void setPricePizza(Double pricePizza) {
        this.pricePizza = pricePizza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(idPizza, pizza.idPizza) && Objects.equals(pathPizza, pizza.pathPizza) && Objects.equals(namePizza, pizza.namePizza) && Objects.equals(descriptionPizza, pizza.descriptionPizza) && Objects.equals(pricePizza, pizza.pricePizza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPizza, pathPizza, namePizza, descriptionPizza, pricePizza);
    }
}



