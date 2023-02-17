package com.navid.recipieapp.domain;

import jakarta.persistence.*;

/**
 * @author n.zare 2/5/2023 $
 */
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String description;
    private Double amount;

    @OneToOne
    private UnitOfMeasures unitOfMeasure;

    @ManyToOne
    private Recipe recipe;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public UnitOfMeasures getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasures unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
