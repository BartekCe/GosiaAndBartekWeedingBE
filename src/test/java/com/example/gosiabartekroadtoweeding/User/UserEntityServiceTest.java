package com.example.gosiabartekroadtoweeding.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserEntityServiceTest {

    @Autowired
    private UserEntityService userEntityService;

    @Test
    void asdsava() {
        var bartek = userEntityService.getUser("Bartek");
            var dayId = Long.parseLong(bartek.getId().toString() + "20220124");
            userEntityService.getDay(dayId);
        System.out.println("after -> " + bartek.getWeeks().size());
    }
}