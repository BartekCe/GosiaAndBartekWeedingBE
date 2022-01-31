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
    public void saveRecipe(@RequestBody RecipeDto recipeDto) {
         recipeService.save(recipeDto);
    }

    @GetMapping(path = "/getRecipe/{name}")
    public RecipeEntity getRecipe(@PathVariable String name) {
        return recipeService.getRecipe(name);
    }

    @GetMapping(path = "/getRecipes")
    public List<RecipeEntity> getRecipes() {
        return recipeService.getAll();
    }
}
