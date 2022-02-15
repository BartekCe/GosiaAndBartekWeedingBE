package com.example.gosiabartekroadtoweeding.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserSimpleData {
    private Long id;
    private String name;
    private double startingWeight;
    private double currentWeight;
    private double goalWeight;
    private int weeklyCaloriesIntake;
    private int dailyCaloriesIntake;
    private int dailyProtein;
    private int dailyFat;
    private int dailyCarbohydrate;
}
