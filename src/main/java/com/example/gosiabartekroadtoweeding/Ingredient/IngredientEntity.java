package com.example.gosiabartekroadtoweeding.Ingredient;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private double protein;
    @NotNull
    private double fat;
    @NotNull
    private double carbohydrate;
    @NotNull
    private double calories;
    @NotNull
    private int grams;

    public IngredientEntity(String name, double protein, double fat, double carbohydrate, double calories, int grams) {
        this.name = name;
        this.protein = protein / grams;
        this.fat = fat / grams;
        this.carbohydrate = carbohydrate / grams;
        this.calories = calories / grams;
        this.grams = 1;
    }

    public IngredientEntity(Long id, String name, double protein, double fat, double carbohydrate, double calories, int grams) {
        this.id = id;
        this.name = name;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.calories = calories;
        this.grams = grams;
    }

    @Override
    public String toString() {
        return "IngredientEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate +
                ", calories=" + calories +
                ", grams=" + grams +
                '}';
    }
}
