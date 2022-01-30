package com.example.gosiabartekroadtoweeding.Meal;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CopyMealDto {
    public LocalDate date;
    public Long userId;
    public MealTag mealTag;
}
