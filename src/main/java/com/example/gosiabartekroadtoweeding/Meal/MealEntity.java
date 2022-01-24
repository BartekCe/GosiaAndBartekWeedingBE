package com.example.gosiabartekroadtoweeding.Meal;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimple;
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
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    List<IngredientSimple> ingredients;
    private int calories;
    @Column(columnDefinition="Decimal(10,4)")
    private BigDecimal protein;
    @Column(columnDefinition="Decimal(10,4)")
    private BigDecimal fat;
    @Column(columnDefinition="Decimal(10,4)")
    private BigDecimal carbohydrate;
    private MealTag mealTag;

    public MealEntity(Long id, List<IngredientSimple> ingredients, int calories, BigDecimal protein, BigDecimal fat, BigDecimal carbohydrate, MealTag mealTag) {
        this.id = id;
        this.ingredients = ingredients;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.mealTag = mealTag;
    }

    public MealEntity(List<IngredientSimple> ingredients, MealTag mealTag){
        this.calories = 0;
        this.protein = BigDecimal.valueOf(0);
        this.fat = BigDecimal.valueOf(0);
        this.carbohydrate = BigDecimal.valueOf(0);
        this.mealTag = mealTag;
        this.ingredients = ingredients;
    }
}
