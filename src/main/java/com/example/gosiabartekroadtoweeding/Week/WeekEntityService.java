package com.example.gosiabartekroadtoweeding.Week;

import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public WeekData getWeekByDayId(Long dayId) {
        var week = weekEntityRepository.findAll().stream()
                .filter(weekEntity -> weekEntity.getDays().stream().anyMatch(day -> day.getId().equals(dayId))).findAny();
        if (week.isPresent()) {
            var weekData = new WeekData(week.get().getWeeklyCaloriesIntake());
            week.get().getDays().forEach(day -> day.getMeals()
                    .forEach(mealEntity -> weekData.setCurrentCalories(weekData.getCurrentCalories() + mealEntity.getCalories())));
            return weekData;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "There is no week with that dayId: " + dayId + "in it");
        }
    }
}
