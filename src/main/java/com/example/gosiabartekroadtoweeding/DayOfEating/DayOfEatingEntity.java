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
        this.date = LocalDate.now();
        this.calories = meals.stream().mapToInt(MealEntity::getCalories).sum();
    }

}
