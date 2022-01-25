package com.example.gosiabartekroadtoweeding.User;

import com.example.gosiabartekroadtoweeding.Week.WeekEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @OneToMany
    private List<WeekEntity> weeks;

    public UserEntity(String name, double currentWeight, double goalWeight
            ,int weeklyCaloriesIntake, int dailyCaloriesIntake, int dailyProtein, int dailyFat, int dailyCarbohydrate) {
        this.name = name;
        this.startingWeight = currentWeight;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.weeklyCaloriesIntake = weeklyCaloriesIntake;
        this.dailyCaloriesIntake = dailyCaloriesIntake;
        this.dailyProtein = dailyProtein;
        this.dailyFat = dailyFat;
        this.dailyCarbohydrate = dailyCarbohydrate;
        this.weeks = new ArrayList<>();
    }
}
