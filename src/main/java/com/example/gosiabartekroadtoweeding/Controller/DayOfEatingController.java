package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingEntity;
import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingService;
import com.example.gosiabartekroadtoweeding.Meal.MealCreationDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
public class DayOfEatingController {
    private final DayOfEatingService dayOfEatingService;

    public DayOfEatingController(DayOfEatingService dayOfEatingService) {
        System.out.println("a takie tam");
        this.dayOfEatingService = dayOfEatingService;
    }

    @PostMapping(path = "/addNewMeal")
    public void createNewMeal(@RequestBody MealCreationDto mealCreationDto) {
        dayOfEatingService.createNewMeal(mealCreationDto);
    }

    @GetMapping(path = "/getDayOfEating/{id}")
    public DayOfEatingEntity getDay(@PathVariable Long id) {
        return dayOfEatingService.getDay(id);
    }
}
