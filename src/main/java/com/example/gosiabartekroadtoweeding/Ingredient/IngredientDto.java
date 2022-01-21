package com.example.gosiabartekroadtoweeding.Ingredient;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public class IngredientDto {
    @NotNull
    private final String name;
    @NotNull
    private final double protein;
    @NotNull
    private final double fat;
    @NotNull
    private final double carbohydrate;
    @NotNull
    private final double calories;
    @NotNull
    private final int grams;

    public boolean withoutNulls(){
        System.out.println(this);
       return Stream.of(this.name,this.protein,this.fat,this.carbohydrate,this.calories,this.grams)
                .allMatch(Objects::nonNull);
    }

    @Override
    public String toString() {
        return "IngredientDto{" +
                "name='" + name + '\'' +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate +
                ", calories=" + calories +
                ", grams=" + grams +
                '}';
    }
}
