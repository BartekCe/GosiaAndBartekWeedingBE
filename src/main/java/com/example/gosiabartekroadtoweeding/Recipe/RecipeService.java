package com.example.gosiabartekroadtoweeding.Recipe;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimpleService;
import com.example.gosiabartekroadtoweeding.Ingredient.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final IngredientSimpleService ingredientSimpleService;
    private final IngredientService ingredientService;

    public RecipeService(RecipeRepository recipeRepository, IngredientSimpleService ingredientSimpleService, IngredientService ingredientService) {
        this.recipeRepository = recipeRepository;
        this.ingredientSimpleService = ingredientSimpleService;
        this.ingredientService = ingredientService;
    }

    public void save(RecipeDto recipeDto) {
        var recipe = recipeRepository.getByName(recipeDto.getName());
        if (recipe.isPresent()) {
            if (recipe.get().getName().equals(recipeDto.getName())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Recipe with that name " + recipeDto.getName() + " exist");
            }
        }
        if (recipeDto.getName().length() <= 2) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Recipe should have min 3 sign");
        }
        if(recipeDto.getIngredients().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Recipe should have ingredients");
        }
        if(recipeDto.getIngredients().size() == 1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Recipe should have more than one ingredient");
        }

        var ingredients = ingredientService.convertSimpleIngredients(recipeDto.getIngredients());
        recipeRepository.save(new RecipeEntity(recipeDto.getName(),
                ingredientSimpleService.saveAll(recipeDto.getIngredients()),
                ingredients.stream().mapToInt(ingredient -> ingredient.getCalories().intValue()).sum(),
                BigDecimal.valueOf(ingredients.stream().mapToDouble(ingredient -> ingredient.getProtein().doubleValue()).sum()).setScale(2, RoundingMode.FLOOR),
                BigDecimal.valueOf(ingredients.stream().mapToDouble(ingredient -> ingredient.getFat().doubleValue()).sum()).setScale(2, RoundingMode.FLOOR),
                BigDecimal.valueOf(ingredients.stream().mapToDouble(ingredient -> ingredient.getCarbohydrate().doubleValue()).sum()).setScale(2, RoundingMode.FLOOR)));
    }

    public RecipeEntity getRecipe(String name) {
        var recipeEntity = recipeRepository.findByName(name);
        if (recipeEntity.isPresent()) {
            return recipeEntity.get();
        } else throw new IllegalArgumentException("Recipe " + name + " does not exist");
    }

    public List<RecipeEntity> getAll() {
        return recipeRepository.findAll();
    }
}
