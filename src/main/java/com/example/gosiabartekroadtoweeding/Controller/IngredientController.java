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

    @GetMapping(path = "/getIngredient")
    public IngredientEntity getIngredient(@RequestBody String name) {
        return ingredientService.getIngredientData(name);
    }

    @GetMapping(path = "/getIngredientsList")
    public List<String> getIngredientsNames() {
        return ingredientService.getIngredientsNames();
    }

    @PutMapping(path = "/updateIngredient")
    public void updateIngredient(@RequestBody IngredientDto ingredientDto){
        ingredientService.updateIngredient(ingredientDto);
    }
}
