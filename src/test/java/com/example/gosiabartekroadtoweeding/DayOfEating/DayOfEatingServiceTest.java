package com.example.gosiabartekroadtoweeding.DayOfEating;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DayOfEatingServiceTest {

    @Autowired
    private DayOfEatingService dayOfEatingService;


    @Test
    void asdasd() {
        var dayId= 120220130L;
       var days = dayOfEatingService.saveAllWeek(dayId);
        System.out.println(days.size());
    }

    @Test
    void dasdasdasd() {
        var dayId= 120220130L;
        var x =dayOfEatingService.getPreviousDayIdFromDayId(dayId);
        System.out.println(x);
    }
}