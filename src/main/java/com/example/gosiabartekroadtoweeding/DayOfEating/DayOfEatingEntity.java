package com.example.gosiabartekroadtoweeding.DayOfEating;

import com.example.gosiabartekroadtoweeding.Meal.MealEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class DayOfEatingEntity {
    @Id
    private Long id;
    @OneToMany
    List<MealEntity> meals;
    private LocalDate date;
    private DayOfWeek dayTag;

    public DayOfEatingEntity(Long dayId, List<MealEntity> meals) {
        this.id = dayId;
        this.meals = meals;
        this.date = getDateFormId(dayId);
        this.dayTag = this.date.getDayOfWeek();
    }

    private LocalDate getDateFormId(Long dayId){
        var x = dayId.toString().substring(dayId.toString().length() -8);
        return  LocalDate.of(Integer.parseInt(x.substring(0,4)), Integer.parseInt(x.substring(4,6)), Integer.parseInt(x.substring(6)));
    }
}
