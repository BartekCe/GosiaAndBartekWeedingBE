package com.example.gosiabartekroadtoweeding.User;

import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingEntity;
import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserEntityService {
    private final UserEntityRepository userEntityRepository;
    private final DayOfEatingService dayOfEatingService;

    public UserEntityService(UserEntityRepository userEntityRepository, DayOfEatingService dayOfEatingService) {
        this.userEntityRepository = userEntityRepository;
        this.dayOfEatingService = dayOfEatingService;
    }

    public void save(UserDto userDto) {
        userEntityRepository.save(new UserEntity(userDto.getName(),
                userDto.getCurrentWeight(), userDto.getGoalWeight(),
                userDto.getWeeklyCaloriesIntake(), userDto.getDailyCaloriesIntake(),
                userDto.getDailyProtein(), userDto.getDailyFat(), userDto.getDailyCarbohydrate()));
    }

    public UserEntity getUser(String name) {
        var user = userEntityRepository.getByName(name);
        if (user.isPresent()) {
            return user.get();
        } else throw new IllegalArgumentException("User with this " + name + " does not exist.");
    }

    public List<DayOfEatingEntity> getUserDays(String name) {
        var user = getUser(name);
        return user.getDaysOfEating();
    }

    public void createNewDay(String name) {
        var user = getUser(name);
        user.getDaysOfEating().add(dayOfEatingService.createNewDayOfEating(user.getId()));
        userEntityRepository.save(user);
    }

    public void updateUser(UserDto userDto) {
        var user = userEntityRepository.getByName(userDto.getName());
        if (user.isPresent()) {
            userEntityRepository.save(new UserEntity(user.get().getId(), userDto.getName(),
                    user.get().getStartingWeight(), userDto.getCurrentWeight(),
                    userDto.getGoalWeight(), userDto.getWeeklyCaloriesIntake(),
                    userDto.getDailyCaloriesIntake(), userDto.getDailyProtein(),
                    userDto.getDailyFat(), userDto.getDailyCarbohydrate(), user.get().getDaysOfEating()));

        } else throw new IllegalArgumentException("User with this name" + userDto.getName() + " does not exist.");
    }

    public List<String> getUsersNames() {
        var names = new ArrayList<String>();
        userEntityRepository.findAll().forEach(user -> {
            names.add(user.getName());
        });
        return names;
    }

    public UserSimpleData getUserData(String name) {
        var user = getUser(name);
        return new UserSimpleData(user.getId(), user.getName(), user.getStartingWeight(), user.getCurrentWeight(),
                user.getGoalWeight(), user.getWeeklyCaloriesIntake(),
                user.getDailyCaloriesIntake(), user.getDailyProtein(),
                user.getDailyFat(), user.getDailyCarbohydrate());
    }

    public List<UserEntity> getUsers() {
        return userEntityRepository.findAll();
    }
}