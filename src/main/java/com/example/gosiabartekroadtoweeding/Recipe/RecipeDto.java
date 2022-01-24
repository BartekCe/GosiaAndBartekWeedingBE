package com.example.gosiabartekroadtoweeding.Recipe;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimple;
import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimpleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class RecipeDto {
    private final String name;
    private final List<IngredientSimpleDto> ingredients;

    @Override
    public String toString() {
        return "RecipeDto{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
