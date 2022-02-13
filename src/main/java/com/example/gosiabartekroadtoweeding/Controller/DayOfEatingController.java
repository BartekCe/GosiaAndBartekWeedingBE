package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingEntity;
import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping(path = "/dayOfEating")
public class DayOfEatingController {
    private final DayOfEatingService dayOfEatingService;

    public DayOfEatingController(DayOfEatingService dayOfEatingService) {
        this.dayOfEatingService = dayOfEatingService;
    }

    @GetMapping(path = "/get/{id}")
    public DayOfEatingEntity getDay(@PathVariable Long id) {
        return dayOfEatingService.getDay(id);
    }

    @GetMapping(path = "/checkIfExist/{id}")
    public boolean isDayExist(@PathVariable Long id){
        return dayOfEatingService.existById(id);
    }
}
