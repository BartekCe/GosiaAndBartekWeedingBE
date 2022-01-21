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

    public DayOfEatingEntity createNewDayOfEating(Long userId) {
        var newDayId = createId(userId);
        if (!dayOfEatingRepository.existsById(newDayId)) {
            return dayOfEatingRepository.save(new DayOfEatingEntity(newDayId, mealService.createEmptyMeals()));
        } else
            throw new IllegalArgumentException("User with that " + userId + " already created day at " + LocalDate.now());
    }

    private Long createId(Long userId) {
        return Long.parseLong(userId.toString() + LocalDate.now().toString().replaceAll("-", ""));
    }

    public DayOfEatingEntity getDay(Long id) {
        if (dayOfEatingRepository.existsById(id)) {
            return dayOfEatingRepository.findById(id).get();
        } else {
            var dayId = Long.toString(id);
            var userId = dayId.substring(0, dayId.length() - 8);
            return createNewDayOfEating(Long.parseLong(userId));
        }
    }

    public void createNewMeal(MealCreationDto mealCreationDto) {
        var dayOfEating = getDay(mealCreationDto.getDayId());
        dayOfEating.getMeals().add(mealService.save(mealCreationDto));
        dayOfEatingRepository.save(dayOfEating);
    }
}
