package com.example.gosiabartekroadtoweeding.Meal;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimple;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MealCreationDto {
    private final Long dayId;
    private final Integer mealNumber;
    private final List<IngredientSimple> ingredients;
    private final int calories;

    @Override
    public String toString() {
        return "MealCreationDto{" +
                "dayId=" + dayId +
                ", mealNumber=" + mealNumber +
                ", ingredients=" + ingredients +
                ", calories=" + calories +
                '}';
    }
}