package com.example.gosiabartekroadtoweeding.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    private final String name;
    private final double currentWeight;
    private final double goalWeight;
    private final int weeklyCaloriesIntake;
    private final int dailyCaloriesIntake;
    private final int dailyProtein;
    private final int dailyFat;
    private final int dailyCarbohydrate;

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", currentWeight=" + currentWeight +
                ", goalWeight=" + goalWeight +
                ", weeklyCaloriesIntake=" + weeklyCaloriesIntake +
                ", dailyCaloriesIntake=" + dailyCaloriesIntake +
                ", dailyProtein=" + dailyProtein +
                ", dailyFat=" + dailyFat +
                ", dailyCarbohydrate=" + dailyCarbohydrate +
                '}';
    }
}
