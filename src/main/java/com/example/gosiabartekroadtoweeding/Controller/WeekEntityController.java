package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.Week.WeekEntityService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeekEntityController {
    private final WeekEntityService weekEntityService;

    public WeekEntityController(WeekEntityService weekEntityService) {
        this.weekEntityService = weekEntityService;
    }
}
