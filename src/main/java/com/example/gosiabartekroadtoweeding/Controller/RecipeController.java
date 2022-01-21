package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.Recipe.RecipeDto;
import com.example.gosiabartekroadtoweeding.Recipe.RecipeEntity;
import com.example.gosiabartekroadtoweeding.Recipe.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping(path = "/addRecipe")
    public RecipeEntity saveRecipe(@RequestBody RecipeDto recipeDto) {
        return recipeService.save(recipeDto);
    }

    @GetMapping(path = "/getRecipe/{name}")
    public RecipeEntity getRecipe(@PathVariable String name) {
        return recipeService.getRecipe(name);
    }

    @GetMapping(path = "/getAllRecipes")
    public List<RecipeEntity> getAll() {
        return recipeService.getAll();
    }

    @GetMapping(path = "/getRecipesList")
    public List<String> getRecipesNames() {
        return recipeService.getRecipesNames();
    }
}
