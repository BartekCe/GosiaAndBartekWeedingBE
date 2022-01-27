package com.example.gosiabartekroadtoweeding.Meal;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimpleService;
import com.example.gosiabartekroadtoweeding.Ingredient.IngredientService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class MealService {
    private final MealRepository mealRepository;
    private final IngredientSimpleService ingredientSimpleService;
    private final IngredientService ingredientService;

    public MealService(MealRepository mealRepository, IngredientSimpleService ingredientSimpleService, IngredientService ingredientService) {
        this.mealRepository = mealRepository;
        this.ingredientSimpleService = ingredientSimpleService;
        this.ingredientService = ingredientService;
    }

    private void update(MealDto mealDto) {
        var ingredients = ingredientService.convertSimpleIngredients(mealDto.getIngredients());
        mealRepository.save(new MealEntity(mealDto.getMealId(),
                ingredientSimpleService.saveAll(mealDto.getIngredients()),
                ingredients.stream().mapToInt(ingredient -> ingredient.getCalories().intValue()).sum(),
                BigDecimal.valueOf(ingredients.stream().mapToDouble(ingredient -> ingredient.getProtein().doubleValue()).sum()).setScale(2, RoundingMode.FLOOR),
                BigDecimal.valueOf(ingredients.stream().mapToDouble(ingredient -> ingredient.getFat().doubleValue()).sum()).setScale(2, RoundingMode.FLOOR),
                BigDecimal.valueOf(ingredients.stream().mapToDouble(ingredient -> ingredient.getCarbohydrate().doubleValue()).sum()).setScale(2, RoundingMode.FLOOR),
                mealDto.getMealTag()));
    }

    public List<MealEntity> createEmptyMeals() {
        return mealRepository.saveAll(List.of(
                new MealEntity(ingredientSimpleService.saveAllWithEmpty(ingredientSimpleService.emptyIngredients()), MealTag.BREAKFAST),
                new MealEntity(ingredientSimpleService.saveAllWithEmpty(ingredientSimpleService.emptyIngredients()), MealTag.LUNCH),
                new MealEntity(ingredientSimpleService.saveAllWithEmpty(ingredientSimpleService.emptyIngredients()), MealTag.DINNER),
                new MealEntity(ingredientSimpleService.saveAllWithEmpty(ingredientSimpleService.emptyIngredients()), MealTag.OTHER)
        ));
    }

    public MealEntity getMeal(Long id) {
        return mealRepository.findById(id).get();
    }

    public void updateMeal(MealDto mealDto) {
        if (mealRepository.existsById(mealDto.getMealId())) {
            update(mealDto);
        } else throw new IllegalArgumentException(" " + mealDto.getMealId() + " does not exist");
    }
}
