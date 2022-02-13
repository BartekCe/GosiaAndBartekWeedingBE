package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingEntity;
import com.example.gosiabartekroadtoweeding.Meal.CopyMealDto;
import com.example.gosiabartekroadtoweeding.Meal.MealEntity;
import com.example.gosiabartekroadtoweeding.User.UserSimpleData;
import com.example.gosiabartekroadtoweeding.User.UserDto;
import com.example.gosiabartekroadtoweeding.User.UserEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserEntityService userEntityService;

    public UserController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @GetMapping(path = "/getAllNames")
    public List<String> getUsersNames(){
        return userEntityService.getUsersNames();
    }

    @GetMapping(path = "/getAll")
    public List<UserSimpleData> getUsers(){
        return userEntityService.getUsers();
    }

    @GetMapping(path="/getDay/{dayId}")
    public DayOfEatingEntity getDay(@PathVariable Long dayId){
        return userEntityService.getDay(dayId);
    }

    @PutMapping(path="/update")
    public void updateUser(@RequestBody UserDto userDto){
        userEntityService.updateUser(userDto);
    }

    @PostMapping(path = "/createNewWeek/{userId}")
    public boolean createNewWeek(@PathVariable Long userId){
        return userEntityService.createNewWeek(userId);
    }

    @PostMapping(path = "/copyMeal")
    public MealEntity copyMeal(@RequestBody CopyMealDto copyMealDto){
        return userEntityService.copyMeal(copyMealDto);
    }

    @PostMapping(path = "/createDefault")
    public void createDefault(){
        userEntityService.createDefault();
    }
}