package com.example.gosiabartekroadtoweeding.Recipe;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimpleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
    private  Long id;
    private  String name;
    private  List<IngredientSimpleDto> ingredients;

    @Override
    public String toString() {
        return "RecipeDto{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
