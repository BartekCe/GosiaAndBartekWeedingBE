package com.example.gosiabartekroadtoweeding.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private double currentWeight;
    private double goalWeight;
    private int weeklyCaloriesIntake;
    private int dailyCaloriesIntake;
    private int dailyProtein;
    private int dailyFat;
    private int dailyCarbohydrate;

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
