package com.example.gosiabartekroadtoweeding.Meal.Week;

import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingService;
import org.springframework.stereotype.Service;

@Service
public class WeekEntityService {
    private final WeekEntityRepository weekEntityRepository;
    private final DayOfEatingService dayOfEatingService;

    public WeekEntityService(WeekEntityRepository weekEntityRepository, DayOfEatingService dayOfEatingService) {
        this.weekEntityRepository = weekEntityRepository;
        this.dayOfEatingService = dayOfEatingService;
    }

    public WeekEntity addNewWeek(Long dayId, int weeklyCaloriesIntake) {
           return weekEntityRepository.save(new WeekEntity(dayOfEatingService.saveAllWeek(dayId), weeklyCaloriesIntake));
    }
}
