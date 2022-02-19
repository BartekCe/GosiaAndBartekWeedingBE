package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.Ingredient.IngredientDto;
import com.example.gosiabartekroadtoweeding.Ingredient.IngredientEntity;
import com.example.gosiabartekroadtoweeding.Ingredient.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping(path = "/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping(path = "/add")
    public IngredientEntity addIngredient(@RequestBody IngredientDto ingredientDto) {
        return ingredientService.save(ingredientDto);
    }

    @PostMapping(path = "/addMany")
    public void addIngredients(@RequestBody List<IngredientEntity> ingredients) {
        ingredientService.saveAll(ingredients);
    }

    @GetMapping(path = "/get/{name}")
    public IngredientEntity getIngredient(@PathVariable String name) {
        return ingredientService.getIngredientData(name);
    }

    @GetMapping(path = "/getAllNames")
    public List<String> getIngredientsNames() {
        return ingredientService.getIngredientsNames();
    }

    @GetMapping(path = "/getAll")
    public List<IngredientEntity> getIngredients() {
        return ingredientService.getIngredients();
    }

    @PutMapping(path = "/update")
    public void updateIngredient(@RequestBody IngredientDto ingredientDto){
        ingredientService.updateIngredient(ingredientDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteIngredient(@PathVariable Long id){
        ingredientService.delete(id);
    }
}