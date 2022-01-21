package com.example.gosiabartekroadtoweeding.Meal;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimpleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private final MealRepository mealRepository;
    private final IngredientSimpleService ingredientSimpleService;

    public MealService(MealRepository mealRepository, IngredientSimpleService ingredientSimpleService) {
        this.mealRepository = mealRepository;
        this.ingredientSimpleService = ingredientSimpleService;
    }

    public MealEntity save(MealCreationDto mealCreationDto) {
        return mealRepository.save(new MealEntity(ingredientSimpleService.saveAll(mealCreationDto.getIngredients()), mealCreationDto.getDayId(), mealCreationDto.getCalories()));
    }

    private void update(ExistingMealDto mealDto) {
        mealRepository.save(new MealEntity(ingredientSimpleService.saveAll(mealDto.getIngredients()), mealDto.getMealId(), mealDto.getCalories()));
    }

    public List<MealEntity> createEmptyMeals(){
        return mealRepository.saveAll(List.of(
                new MealEntity(ingredientSimpleService.saveAll(ingredientSimpleService.emptyIngredients())),
                new MealEntity(ingredientSimpleService.saveAll(ingredientSimpleService.emptyIngredients())),
                new MealEntity(ingredientSimpleService.saveAll(ingredientSimpleService.emptyIngredients()))
        ));
    }

    public MealEntity getMeal(Long id) {
        return mealRepository.findById(id).get();
    }

    public void updateMeal(ExistingMealDto existingMealDto) {
        if (mealRepository.existsById(existingMealDto.getMealId())) {
            update(existingMealDto);
        } else throw new IllegalArgumentException(" " + existingMealDto.getMealId() + " does not exist");
    }
}
