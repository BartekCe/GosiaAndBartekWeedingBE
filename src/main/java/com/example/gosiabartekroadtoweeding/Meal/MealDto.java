package com.example.gosiabartekroadtoweeding.Meal;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimpleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MealDto {
    private  Long mealId;
    private  List<IngredientSimpleDto> ingredients;
    private  int calories;
    private BigDecimal protein;
    private BigDecimal fat;
    private BigDecimal carbohydrate;
    private MealTag mealTag;

    @Override
    public String toString() {
        return "ExistingMealDto{" +
                "mealId=" + mealId +
                ", ingredients=" + ingredients +
                ", calories=" + calories +
                '}';
    }
}
