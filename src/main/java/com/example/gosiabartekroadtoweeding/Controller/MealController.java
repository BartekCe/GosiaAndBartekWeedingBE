package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.Meal.ExistingMealDto;
import com.example.gosiabartekroadtoweeding.Meal.MealEntity;
import com.example.gosiabartekroadtoweeding.Meal.MealService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
public class MealController {
    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping(path = "/getMeal")
    public MealEntity getMeal(@RequestBody Long id){
        return mealService.getMeal(id);
    }

    @PutMapping(path = "/updateMeal")
    public void updateMeal(@RequestBody ExistingMealDto existingMealDto){
        mealService.updateMeal(existingMealDto);
    }

}
