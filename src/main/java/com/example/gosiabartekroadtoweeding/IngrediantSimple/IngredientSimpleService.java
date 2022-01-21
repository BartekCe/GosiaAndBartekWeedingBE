package com.example.gosiabartekroadtoweeding.IngrediantSimple;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientSimpleService {

    private final IngredientSimpleRepository ingredientSimpleRepository;

    public IngredientSimpleService(IngredientSimpleRepository ingredientSimpleRepository) {
        this.ingredientSimpleRepository = ingredientSimpleRepository;
    }

    public List<IngredientSimple> saveAll(List<IngredientSimple> ingredients){
       return ingredientSimpleRepository.saveAll(ingredients);
    }

    public List<IngredientSimple> emptyIngredients(){
        return List.of(
                new IngredientSimple(0, "1 ingredient"),
                new IngredientSimple(0, "2 ingredient"),
                new IngredientSimple(0, "3 ingredient")
        );
    }
}
