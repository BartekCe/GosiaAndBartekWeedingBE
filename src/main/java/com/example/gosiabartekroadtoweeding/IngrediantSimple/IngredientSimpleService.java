package com.example.gosiabartekroadtoweeding.IngrediantSimple;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientSimpleService {

    private final IngredientSimpleRepository ingredientSimpleRepository;

    public IngredientSimpleService(IngredientSimpleRepository ingredientSimpleRepository) {
        this.ingredientSimpleRepository = ingredientSimpleRepository;
    }

    public List<IngredientSimple> saveAll(List<IngredientSimpleDto> ingredients) {
        List<IngredientSimple> ingredientSimples = new ArrayList<>();
        ingredients.forEach(ingredient -> ingredientSimples.add(new IngredientSimple(ingredient.getGrams(), ingredient.getName(), ingredient.getNumber())));
        return ingredientSimpleRepository.saveAll(ingredientSimples);
    }

    public List<IngredientSimple> saveAllWithEmpty(List<IngredientSimple> ingredients) {
        List<IngredientSimple> ingredientSimples = new ArrayList<>();
        ingredients.forEach(ingredient -> ingredientSimples.add(new IngredientSimple(ingredient.getGrams(), ingredient.getName(), ingredient.getNumber())));
        return ingredientSimpleRepository.saveAll(ingredientSimples);
    }

    public List<IngredientSimple> emptyIngredients() {
        return List.of(
                new IngredientSimple(0, "1 ingredient", 1),
                new IngredientSimple(0, "2 ingredient", 2),
                new IngredientSimple(0, "3 ingredient", 3)
        );
    }
}
