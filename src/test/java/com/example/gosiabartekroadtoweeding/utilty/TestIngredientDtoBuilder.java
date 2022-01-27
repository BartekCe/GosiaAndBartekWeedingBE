package com.example.gosiabartekroadtoweeding.utilty;

import com.example.gosiabartekroadtoweeding.Ingredient.IngredientDto;

import java.math.BigDecimal;

public class TestIngredientDtoBuilder {
    private final IngredientDto ingredient = new IngredientDto();

    public static TestIngredientDtoBuilder existingOne() {
        final var builder = new TestIngredientDtoBuilder();
        builder.ingredient.setName("apple");
        builder.ingredient.setProtein(BigDecimal.valueOf(2));
        builder.ingredient.setFat(BigDecimal.valueOf(0.6));
        builder.ingredient.setCarbohydrate(BigDecimal.valueOf(12));
        builder.ingredient.setGrams(100);
        return builder;
    }
    public static TestIngredientDtoBuilder newIngredient(String name) {
        final var builder = new TestIngredientDtoBuilder();
        builder.ingredient.setName(name);
        builder.ingredient.setProtein(BigDecimal.valueOf(2));
        builder.ingredient.setFat(BigDecimal.valueOf(0.6));
        builder.ingredient.setCarbohydrate(BigDecimal.valueOf(12));
        builder.ingredient.setGrams(100);
        return builder;
    }


//
    public IngredientDto build() {
        return ingredient;
    }
}
