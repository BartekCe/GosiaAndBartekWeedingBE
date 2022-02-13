package com.example.gosiabartekroadtoweeding.Week;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeekData {
    private int currentCalories;
    private int weeklyCaloriesIntake;
    private double weightOnStart;

    public WeekData(int weeklyCaloriesIntake, double weightOnStart) {
        this.weeklyCaloriesIntake = weeklyCaloriesIntake;
        this.weightOnStart = weightOnStart;
        currentCalories = 0;
    }
}
