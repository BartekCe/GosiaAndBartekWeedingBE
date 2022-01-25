package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingEntity;
import com.example.gosiabartekroadtoweeding.User.UserSimpleData;
import com.example.gosiabartekroadtoweeding.User.UserDto;
import com.example.gosiabartekroadtoweeding.User.UserEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
public class UserController {
    private final UserEntityService userEntityService;

    public UserController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @GetMapping(path = "/getUsersNames")
    public List<String> getUsersNames(){
        return userEntityService.getUsersNames();
    }

    @GetMapping(path = "/getUsers")
    public List<UserSimpleData> getUsers(){
        return userEntityService.getUsers();
    }

    @GetMapping(path="/getDay/{dayId}")
    public DayOfEatingEntity getDay(@PathVariable Long dayId){
        return userEntityService.getDay(dayId);
    }

    @PutMapping(path="/updateUser")
    public void updateUser(@RequestBody UserDto userDto){
        userEntityService.updateUser(userDto);
    }
}