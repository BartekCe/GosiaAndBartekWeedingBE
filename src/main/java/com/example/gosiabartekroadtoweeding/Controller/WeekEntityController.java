package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.Week.WeekData;
import com.example.gosiabartekroadtoweeding.Week.WeekEntityService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
public class WeekEntityController {
    private final WeekEntityService weekEntityService;

    public WeekEntityController(WeekEntityService weekEntityService) {
        this.weekEntityService = weekEntityService;
    }

    @GetMapping(path = "/getWeek/{dayId}")
    public WeekData getWeek(@PathVariable Long dayId){
        return weekEntityService.getWeekByDayId(dayId);
    }
}
