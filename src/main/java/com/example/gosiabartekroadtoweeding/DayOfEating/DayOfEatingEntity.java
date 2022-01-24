package com.example.gosiabartekroadtoweeding.DayOfEating;

import com.example.gosiabartekroadtoweeding.Meal.MealEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private int calories;

    public DayOfEatingEntity(Long id, List<MealEntity> meals) {
        this.id = id;
        this.meals = meals;
        this.date = getDateFormId(id);
        this.calories = meals.stream().mapToInt(MealEntity::getCalories).sum();
    }

    private LocalDate getDateFormId(Long id){
        var x = id.toString().substring(2);
        return  LocalDate.of(Integer.parseInt(x.substring(0,4)), Integer.parseInt(x.substring(4,6)), Integer.parseInt(x.substring(6)));
    }
}
