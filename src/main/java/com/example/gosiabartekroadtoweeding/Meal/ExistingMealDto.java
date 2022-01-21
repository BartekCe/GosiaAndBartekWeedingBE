package com.example.gosiabartekroadtoweeding.Meal;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimple;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ExistingMealDto {
    private final Long mealId;
    private final List<IngredientSimple> ingredients;
    private final double calories;

    @Override
    public String toString() {
        return "ExistingMealDto{" +
                "mealId=" + mealId +
                ", ingredients=" + ingredients +
                ", calories=" + calories +
                '}';
    }
}
