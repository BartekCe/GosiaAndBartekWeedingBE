package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.Meal.MealDto;
import com.example.gosiabartekroadtoweeding.Meal.MealEntity;
import com.example.gosiabartekroadtoweeding.Meal.MealService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping(path = "/meal")
public class MealController {
    private final MealService mealService;
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }
    @GetMapping(path = "/get/{id}")
    public MealEntity getMeal(@PathVariable Long id){
        return mealService.getMeal(id);
    }

    @PutMapping(path = "/update")
        public void updateMeal(@RequestBody MealDto mealDto){
            mealService.updateMeal(mealDto);
        }
    }