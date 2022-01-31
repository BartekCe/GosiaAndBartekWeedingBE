package com.example.gosiabartekroadtoweeding.Week;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeekData {
    private int currentCalories;
    private int weeklyCaloriesIntake;

    public WeekData(int weeklyCaloriesIntake) {
        this.weeklyCaloriesIntake = weeklyCaloriesIntake;
        currentCalories = 0;
    }
}
