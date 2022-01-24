package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingEntity;
import com.example.gosiabartekroadtoweeding.User.UserSimpleData;
import com.example.gosiabartekroadtoweeding.User.UserDto;
import com.example.gosiabartekroadtoweeding.User.UserEntity;
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

    @PostMapping(path = "addUser")
    public void saveUser(@RequestBody UserDto userDto){
        userEntityService.save(userDto);
    }

    @GetMapping(path="getUser/{name}")
    public UserEntity getUser(@PathVariable String name){
        return userEntityService.getUser(name);
    }

    @GetMapping(path = "getUserData/{name}")
    public UserSimpleData getUserData(@PathVariable String name) {
        return userEntityService.getUserData(name);
    }

    @GetMapping(path = "/getUsersNames")
    public List<String> getUsersNames(){
        return userEntityService.getUsersNames();
    }

    @GetMapping(path = "/getUsers")
    public List<UserEntity> getUsers(){
        System.out.println("elo");
        return userEntityService.getUsers();
    }

    @GetMapping(path="getUserDays/{name}")
    public List<DayOfEatingEntity> getUserDays(@PathVariable String name){
        return userEntityService.getUserDays(name);
    }

    @PostMapping(path="/createNewDay/{name}")
    public void createNewDay(@PathVariable String name){
        userEntityService.createNewDay(name);
    }

    @PutMapping(path="/updateUser")
    public void updateUser(@RequestBody UserDto userDto){
        System.out.println(userDto);
        userEntityService.updateUser(userDto);
    }
}