package com.example.gosiabartekroadtoweeding.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserSimpleData {
    private final Long id;
    private final String name;
    private final double startingWeight;
    private final double currentWeight;
    private final double goalWeight;
    private final int weeklyCaloriesIntake;
    private final int dailyCaloriesIntake;
    private final int dailyProtein;
    private final int dailyFat;
    private final int dailyCarbohydrate;
}
