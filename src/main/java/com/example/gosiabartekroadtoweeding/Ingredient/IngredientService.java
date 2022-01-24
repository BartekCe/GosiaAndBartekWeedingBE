package com.example.gosiabartekroadtoweeding.Ingredient;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimpleDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.*;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
        var defaultIngredients = new DefaultIngredients();
        ingredientRepository.saveAll(List.of(
                new IngredientEntity("Ingredient 1"),
                new IngredientEntity("Ingredient 2"),
                new IngredientEntity("Ingredient 3")
        ));
        if (this.getAll().size() == 3) {
            ingredientRepository.saveAll(defaultIngredients.getDefaultIngredients());
        }
    }

    public IngredientEntity save(IngredientDto ingredientDto) {
        if (!ingredientDto.withoutNulls()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You Can not save i/ngredient with nulls");
        }
        if (ingredientRepository.getByName(ingredientDto.getName()).isEmpty()) {
            return ingredientRepository.save(new IngredientEntity(ingredientDto.getName(), ingredientDto.getProtein(),
                    ingredientDto.getFat(), ingredientDto.getCarbohydrate(), ingredientDto.getGrams()));
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ingredient '" + ingredientDto.getName() + "' all ready exist.");
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
                    ingredientDto.getFat(), ingredientDto.getCarbohydrate(), ingredientDto.getGrams())
            );
        }
        return ingredientEntities;
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

    public boolean isIngredientInDB(String name) {
        return getIngredient(name).isPresent();
    }

    public IngredientEntity getIngredientWithGrams(String name, Integer grams) {
        var ingredient = getIngredient(name);
        var gr = BigDecimal.valueOf(grams);
        if (ingredient.isPresent()) {
            return new IngredientEntity(
                    ingredient.get().getId(),
                    name,
                    ingredient.get().getProtein().multiply(gr),
                    ingredient.get().getFat().multiply(gr),
                    ingredient.get().getCarbohydrate().multiply(gr),
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
        ingredients.stream().filter(ingredientEntity -> !ingredientEntity.getName().contains("Ingredient"))
                .forEach(ingredientEntity -> ingredientsNames.add(ingredientEntity.getName()));
        Collections.sort(ingredientsNames);
        return ingredientsNames;
    }
}
