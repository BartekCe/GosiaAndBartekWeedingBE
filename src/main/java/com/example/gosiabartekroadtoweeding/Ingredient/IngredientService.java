package com.example.gosiabartekroadtoweeding.Ingredient;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimpleDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public IngredientEntity save(IngredientDto ingredientDto) {
        if (!ingredientDto.withoutNulls()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You can not save ingredient with nulls");
        }
        if (ingredientRepository.getByName(ingredientDto.getName()).isEmpty()) {
            return ingredientRepository.save(new IngredientEntity(ingredientDto.getName(), ingredientDto.getProtein(),
                    ingredientDto.getFat(), ingredientDto.getCarbohydrate(), ingredientDto.getGrams()));
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ingredient '" + ingredientDto.getName() + "' all ready exist.");
    }

    public List<IngredientEntity> getAll() {
        return ingredientRepository.findAll();
    }

    public IngredientEntity getIngredientData(String name) {
        var ingredient = getIngredient(name);
        if (ingredient.isPresent()) {
            return ingredient.get();
        } else throw new IllegalArgumentException("Ingredient " + name + " does not exist");
    }

    public List<IngredientEntity> convertSimpleIngredients(List<IngredientSimpleDto> simpleIngredients) {
        var ingredients = new ArrayList<IngredientEntity>();
        simpleIngredients.forEach(simpleIngredient -> {
            var grams = BigDecimal.valueOf(simpleIngredient.getGrams());
            var ing = getIngredientData(simpleIngredient.getName());
            ingredients.add(new IngredientEntity(ing.getId(), ing.getName(),
                    ing.getProtein().multiply(grams),
                    ing.getFat().multiply(grams),
                    ing.getCarbohydrate().multiply(grams),
                    simpleIngredient.getGrams()));
        });
        return ingredients;
    }

    public Optional<IngredientEntity> getIngredient(String name) {
        return ingredientRepository.findByName(name);
    }

    public List<String> getIngredientsNames() {
        var ingredientsNames = new ArrayList<String>();
        var ingredients = getAll();
        ingredients.stream().filter(ingredientEntity -> !ingredientEntity.getName().contains("ingredient"))
                .forEach(ingredientEntity -> ingredientsNames.add(ingredientEntity.getName()));
        Collections.sort(ingredientsNames);
        return ingredientsNames;
    }

    public void updateIngredient(IngredientDto ingredientDto){
        var grams = BigDecimal.valueOf(ingredientDto.getGrams());
        var ingredient = ingredientRepository.getByName(ingredientDto.getName());
        ingredient.ifPresent(ingredientEntity -> ingredientRepository.save(new IngredientEntity(
                ingredientEntity.getId(),
                ingredientDto.getName(),
                ingredientDto.getProtein().divide(grams, 4, RoundingMode.CEILING),
                ingredientDto.getFat().divide(grams, 4, RoundingMode.CEILING),
                ingredientDto.getCarbohydrate().divide(grams, 4, RoundingMode.CEILING),
                1
        )));
    }

    public List<IngredientEntity> getIngredients() {
        return ingredientRepository.findAll();
    }

    public void saveAll(List<IngredientEntity> ingredients) {
        ingredientRepository.saveAll(ingredients);
    }

    public void delete(Long id) {
        ingredientRepository.deleteById(id);
    }
}
