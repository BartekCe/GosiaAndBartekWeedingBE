package com.example.gosiabartekroadtoweeding.Meal;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimpleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class MealDto {
    private final Long mealId;
    private final List<IngredientSimpleDto> ingredients;
    private final int calories;
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
