package com.example.gosiabartekroadtoweeding.DayOfEating;

import com.example.gosiabartekroadtoweeding.Meal.MealCreationDto;
import com.example.gosiabartekroadtoweeding.Meal.MealService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DayOfEatingService {
    private final DayOfEatingRepository dayOfEatingRepository;
    private final MealService mealService;

    public DayOfEatingService(DayOfEatingRepository dayOfEatingRepository, MealService mealService) {
        this.dayOfEatingRepository = dayOfEatingRepository;
        this.mealService = mealService;
    }

    public DayOfEatingEntity createNewDayOfEating(Long dayId) {
        System.out.println("" + dayId);
        if (!dayOfEatingRepository.existsById(dayId)) {
            System.out.println("am i here? ---->" + dayId);
            return dayOfEatingRepository.save(new DayOfEatingEntity(dayId, mealService.createEmptyMeals()));
        } else
            throw new IllegalArgumentException("User with that " + dayId + " already created day at " + LocalDate.now());
    }

    private Long createId(Long userId) {
        return Long.parseLong(userId.toString() + LocalDate.now().toString().replaceAll("-", ""));
    }

    public DayOfEatingEntity getDay(Long dayId) {
        System.out.println(dayId);
        if (dayOfEatingRepository.existsById(dayId)) {
            return dayOfEatingRepository.findById(dayId).get();
        } else {
            return createNewDayOfEating(dayId);
        }
    }

}
