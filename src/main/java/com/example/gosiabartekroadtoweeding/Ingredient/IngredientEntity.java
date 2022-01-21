package com.example.gosiabartekroadtoweeding.Ingredient;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
    private BigDecimal protein;
    @NotNull
    private BigDecimal fat;
    @NotNull
    private BigDecimal carbohydrate;
    @NotNull
    private BigDecimal calories;
    @NotNull
    private int grams;

    public IngredientEntity(String name, BigDecimal protein, BigDecimal fat, BigDecimal carbohydrate, BigDecimal calories, int grams) {
        this.name = name;
        this.protein = protein.divide(BigDecimal.valueOf(grams),2, RoundingMode.DOWN);
        this.fat = fat.divide(BigDecimal.valueOf(grams),2, RoundingMode.DOWN);
        this.carbohydrate = carbohydrate.divide(BigDecimal.valueOf(grams),2, RoundingMode.DOWN);
        this.calories = calories.divide(BigDecimal.valueOf(grams),2, RoundingMode.DOWN);
        this.grams = 1;
    }

    public IngredientEntity(Long id, String name, BigDecimal protein, BigDecimal fat, BigDecimal carbohydrate, BigDecimal calories, int grams) {
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
