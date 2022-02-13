package com.example.gosiabartekroadtoweeding.Ingredient;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @Column(columnDefinition="Decimal(10,4)")
    private BigDecimal protein;
    @NotNull
    @Column(columnDefinition="Decimal(10,4)")
    private BigDecimal fat;
    @NotNull
    @Column(columnDefinition="Decimal(10,4)")
    private BigDecimal carbohydrate;
    @NotNull
    @Column(columnDefinition="Decimal(10,4)")
    private BigDecimal calories;
    @NotNull
    private int grams;

    public IngredientEntity(String name) {
        this.name = name;
        this.protein = BigDecimal.valueOf(0);
        this.fat = BigDecimal.valueOf(0);
        this.carbohydrate = BigDecimal.valueOf(0);
        this.calories = BigDecimal.valueOf(0);
        this.grams = 0;
    }

    public IngredientEntity(String name, BigDecimal protein, BigDecimal fat, BigDecimal carbohydrate, int grams) {
        this.name = name;
        this.protein = protein.divide(BigDecimal.valueOf(grams), 4, RoundingMode.CEILING);
        this.fat = fat.divide(BigDecimal.valueOf(grams), 4, RoundingMode.CEILING);
        this.carbohydrate = carbohydrate.divide(BigDecimal.valueOf(grams), 4, RoundingMode.CEILING);
        this.calories = (this.protein.multiply(BigDecimal.valueOf(4)))
                .add(this.fat.multiply(BigDecimal.valueOf(8)))
                .add(this.carbohydrate.multiply(BigDecimal.valueOf(4)));
        this.grams = 1;
    }

    public IngredientEntity(Long id, String name, BigDecimal protein, BigDecimal fat, BigDecimal carbohydrate, int grams) {
        this.id = id;
        this.name = name;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.calories = (protein.multiply(BigDecimal.valueOf(4))
                .add(fat.multiply(BigDecimal.valueOf(8)))
                .add(carbohydrate.multiply(BigDecimal.valueOf(4))));
        this.grams = grams;
    }

    public IngredientEntity(String name, double protein, double fat, double carbohydrate) {
        this.name = name;
        this.protein = BigDecimal.valueOf(protein).divide(BigDecimal.valueOf(100), 4, RoundingMode.CEILING);
        this.fat = BigDecimal.valueOf(fat).divide(BigDecimal.valueOf(100), 4, RoundingMode.CEILING);
        this.carbohydrate = BigDecimal.valueOf(carbohydrate).divide(BigDecimal.valueOf(100), 4, RoundingMode.CEILING);
        this.calories = (this.protein.multiply(BigDecimal.valueOf(4)))
                .add(this.fat.multiply(BigDecimal.valueOf(8)))
                .add(this.carbohydrate.multiply(BigDecimal.valueOf(4)));
        this.grams = 1;
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
