package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.Week.WeekData;
import com.example.gosiabartekroadtoweeding.Week.WeekEntityService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping(path = "/week")
public class WeekEntityController {
    private final WeekEntityService weekEntityService;

    public WeekEntityController(WeekEntityService weekEntityService) {
        this.weekEntityService = weekEntityService;
    }

    @GetMapping(path = "/get/{dayId}")
    public WeekData getWeek(@PathVariable Long dayId){
        return weekEntityService.getWeekByDayId(dayId);
    }
}
