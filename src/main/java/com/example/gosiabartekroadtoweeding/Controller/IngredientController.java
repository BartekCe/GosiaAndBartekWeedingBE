package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.Ingredient.IngredientDto;
import com.example.gosiabartekroadtoweeding.Ingredient.IngredientEntity;
import com.example.gosiabartekroadtoweeding.Ingredient.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping(path = "/addIngredient")
    public IngredientEntity addIngredient(@RequestBody IngredientDto ingredientDto) {
        return ingredientService.save(ingredientDto);
    }

    @PostMapping(path = "/addIngredients")
    public List<IngredientEntity> addIngredients(@RequestBody List<IngredientDto> ingredients) {
        return ingredientService.saveAll(ingredients);
    }

    @GetMapping(path = "/getIngredient")
    public IngredientEntity getIngredient(@RequestBody String name) {
        return ingredientService.getIngredientData(name);
    }

    @GetMapping(path = "/isIngredientInDB/{name}")
    public boolean isIngredientInDB(@PathVariable String name) {
        return ingredientService.isIngredientInDB(name);
    }

    @GetMapping(path = "/getIngredientsList")
    public List<String> getIngredientsNames() {
        return ingredientService.getIngredientsNames();
    }
}
