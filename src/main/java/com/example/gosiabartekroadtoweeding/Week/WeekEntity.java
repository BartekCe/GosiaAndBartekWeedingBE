package com.example.gosiabartekroadtoweeding.Week;

import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WeekEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<DayOfEatingEntity> days;
    private int weeklyCaloriesIntake;

    public WeekEntity(List<DayOfEatingEntity> days,  int weeklyCaloriesIntake) {
        this.days = days;
        this.weeklyCaloriesIntake = weeklyCaloriesIntake;
    }
}
