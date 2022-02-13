package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.Recipe.RecipeDto;
import com.example.gosiabartekroadtoweeding.Recipe.RecipeEntity;
import com.example.gosiabartekroadtoweeding.Recipe.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping(path = "/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping(path = "/add")
    public void saveRecipe(@RequestBody RecipeDto recipeDto) {
         recipeService.save(recipeDto);
    }

    @GetMapping(path = "/get/{name}")
    public RecipeEntity getRecipe(@PathVariable String name) {
        return recipeService.getRecipe(name);
    }

    @GetMapping(path = "/getAll")
    public List<RecipeEntity> getRecipes() {
        return recipeService.getAll();
    }

    @PutMapping(path="/update")
    public void updateRecipe(@RequestBody RecipeDto recipeDto) {
        recipeService.update(recipeDto);
    }

    @DeleteMapping(path ="/delete/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.delete(id);
    }
}
