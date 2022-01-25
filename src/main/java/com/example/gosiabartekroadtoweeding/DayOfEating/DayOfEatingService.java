package com.example.gosiabartekroadtoweeding.DayOfEating;

import com.example.gosiabartekroadtoweeding.Meal.MealService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DayOfEatingService {
    private final DayOfEatingRepository dayOfEatingRepository;
    private final MealService mealService;

    public DayOfEatingService(DayOfEatingRepository dayOfEatingRepository, MealService mealService) {
        this.dayOfEatingRepository = dayOfEatingRepository;
        this.mealService = mealService;
    }

    public DayOfEatingEntity createNewDayOfEating(Long dayId) {
        if (!dayOfEatingRepository.existsById(dayId)) {
            return dayOfEatingRepository.save(new DayOfEatingEntity(dayId, mealService.createEmptyMeals()));
        } else
            throw new IllegalArgumentException("User with that " + dayId + " already created day at " + LocalDate.now());
    }

    public DayOfEatingEntity getDay(Long dayId) {
        if (dayOfEatingRepository.existsById(dayId)) {
            return dayOfEatingRepository.findById(dayId).get();
        } else {
            return createNewDayOfEating(dayId);
        }
    }

    public List<DayOfEatingEntity> saveAllWeek(Long dayId){
        List<DayOfEatingEntity> days = new ArrayList<>();
        var userId = dayId.toString().substring(0, dayId.toString().length() -8);
        var date = getDateFormId(dayId);
        var dayTag = date.getDayOfWeek();
        days.add(createNewDayOfEating(dayId));
        var x = 1;
        for(int i = dayTag.getValue(); i < 7; i++){
            var nextDayDate = date.plusDays(x);
            x = x+1;
            var nextDayId = userId + nextDayDate.toString().replace("-", "");
            days.add(createNewDayOfEating(Long.parseLong(nextDayId)));
        }
       return dayOfEatingRepository.saveAll(days);
    }

    public boolean existById(Long dayId){
        return dayOfEatingRepository.existsById(dayId);
    }

    private LocalDate getDateFormId(Long id){
        var x = id.toString().substring(id.toString().length() -8);
        return  LocalDate.of(Integer.parseInt(x.substring(0,4)), Integer.parseInt(x.substring(4,6)), Integer.parseInt(x.substring(6)));
    }
}
