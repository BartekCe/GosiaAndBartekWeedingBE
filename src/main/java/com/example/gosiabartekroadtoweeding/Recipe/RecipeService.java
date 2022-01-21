package com.example.gosiabartekroadtoweeding.Recipe;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimpleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final IngredientSimpleService ingredientSimpleService;

    public RecipeService(RecipeRepository recipeRepository, IngredientSimpleService ingredientSimpleService) {
        this.recipeRepository = recipeRepository;
        this.ingredientSimpleService = ingredientSimpleService;
    }

    public RecipeEntity save(RecipeDto recipeDto) {
        return recipeRepository.save(new RecipeEntity(recipeDto.getName(), ingredientSimpleService.saveAll(recipeDto.getIngredients())));
    }

    public RecipeEntity getRecipe(String name) {
        var recipeEntity = recipeRepository.getByName(name);
        if (recipeEntity.isPresent()) {
            return recipeEntity.get();
        } else throw new IllegalArgumentException("Recipe " + name + " does not exist");
    }

    public List<RecipeEntity> getAll() {
        return recipeRepository.findAll();
    }

    public List<String> getRecipesNames() {
        var recipesNames = new ArrayList<String>();
        var recipes = getAll();
        recipes.forEach(recipeEntity -> recipesNames.add(recipeEntity.getName()));
        Collections.sort(recipesNames);
        return recipesNames;
    }
}
