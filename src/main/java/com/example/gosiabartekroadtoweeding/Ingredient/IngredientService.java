package com.example.gosiabartekroadtoweeding.Ingredient;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public IngredientEntity save(IngredientDto ingredientDto) {
        if(!ingredientDto.withoutNulls()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You Can not save ingredient with nulls");
        }
        if (ingredientRepository.getByName(ingredientDto.getName()).isEmpty()) {
            return ingredientRepository.save(new IngredientEntity(ingredientDto.getName(), ingredientDto.getProtein(),
                    ingredientDto.getFat(), ingredientDto.getCarbohydrate(), ingredientDto.getCalories(), ingredientDto.getGrams()));
        }
        else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ingredient '" + ingredientDto.getName() + "' all ready exist.");
    }

    public List<IngredientEntity> saveAll(List<IngredientDto> ingredientDtos) {
        return ingredientRepository.saveAll(convertIngredients(ingredientDtos));
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

    private List<IngredientEntity> convertIngredients(List<IngredientDto> ingredientDtos) {
        List<IngredientEntity> ingredientEntities = new ArrayList<>();
        for (IngredientDto ingredientDto : ingredientDtos) {
            ingredientEntities.add(new IngredientEntity(ingredientDto.getName(), ingredientDto.getProtein(),
                    ingredientDto.getFat(), ingredientDto.getCarbohydrate(), ingredientDto.getCalories(), 1)
            );
        }
        return ingredientEntities;
    }

    public Optional<IngredientEntity> getIngredient(String name) {
        return ingredientRepository.getByName(name);
    }

    public boolean isIngredientInDB(String name) {
        return getIngredient(name).isPresent();
    }

    private IngredientEntity getIngredientWithGrams(String name, Integer grams) {
        var ingredient = getIngredient(name);
        if (ingredient.isPresent()) {
            return new IngredientEntity(
                    ingredient.get().getId(),
                    name,
                    ingredient.get().getProtein(),
                    ingredient.get().getFat(),
                    ingredient.get().getCarbohydrate(),
                    ingredient.get().getCalories(),
                    grams);
        } else throw new IllegalArgumentException("Ingredient " + name + " does not exist");
    }

    public List<IngredientEntity> getIngredientsData(Map<String, Integer> ingredientMap) {
        var ingredients = new ArrayList<IngredientEntity>();
        for (Map.Entry<String, Integer> ingredient : ingredientMap.entrySet()) {
            ingredients.add(getIngredientWithGrams(ingredient.getKey(), ingredient.getValue()));
        }
        return ingredients;
    }

    public List<String> getIngredientsNames() {
        var ingredientsNames = new ArrayList<String>();
        var ingredients = getAll();
        ingredients.forEach(ingredientEntity -> ingredientsNames.add(ingredientEntity.getName()));

        Collections.sort(ingredientsNames);
        return ingredientsNames;
    }
}
