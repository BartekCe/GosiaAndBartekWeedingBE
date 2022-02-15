package com.example.gosiabartekroadtoweeding.Recipe;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimple;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private List<IngredientSimple> ingredients;
    private int calories;
    @Column(columnDefinition="Decimal(10,4)")
    private BigDecimal protein;
    @Column(columnDefinition="Decimal(10,4)")
    private BigDecimal fat;
    @Column(columnDefinition="Decimal(10,4)")
    private BigDecimal carbohydrate;

    public RecipeEntity(String name, List<IngredientSimple> ingredients, int calories, BigDecimal protein, BigDecimal fat, BigDecimal carbohydrate) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }

    @Override
    public String toString() {
        return "RecipeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}