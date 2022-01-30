package com.example.gosiabartekroadtoweeding.User;

import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingEntity;
import com.example.gosiabartekroadtoweeding.DayOfEating.DayOfEatingService;
import com.example.gosiabartekroadtoweeding.Week.WeekEntity;
import com.example.gosiabartekroadtoweeding.Week.WeekEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserEntityService {
    private final UserEntityRepository userEntityRepository;
    private final DayOfEatingService dayOfEatingService;
    private final WeekEntityService weekEntityService;

    public UserEntityService(UserEntityRepository userEntityRepository, DayOfEatingService dayOfEatingService, WeekEntityService weekEntityService) {
        this.userEntityRepository = userEntityRepository;
        this.dayOfEatingService = dayOfEatingService;
        this.weekEntityService = weekEntityService;
        createDefault();
    }

    public UserEntity getUser(String name) {
        var user = userEntityRepository.getByName(name);
        if (user.isPresent()) {
            return user.get();
        } else throw new IllegalArgumentException("User with this " + name + " does not exist.");
    }

    public void updateUser(UserDto userDto) {
        var user = userEntityRepository.getByName(userDto.getName());
        if (user.isPresent()) {
            userEntityRepository.save(new UserEntity(user.get().getId(), userDto.getName(),
                    user.get().getStartingWeight(), userDto.getCurrentWeight(),
                    userDto.getGoalWeight(), userDto.getWeeklyCaloriesIntake(),
                    userDto.getDailyCaloriesIntake(), userDto.getDailyProtein(),
                    userDto.getDailyFat(), userDto.getDailyCarbohydrate(), user.get().getWeeks()));

        } else throw new IllegalArgumentException("User with this name" + userDto.getName() + " does not exist.");
    }

    public List<String> getUsersNames() {
        var names = new ArrayList<String>();
        userEntityRepository.findAll().forEach(user -> names.add(user.getName()));
        return names;
    }

    public UserSimpleData getUserData(String name) {
        var user = getUser(name);
        return new UserSimpleData(user.getId(), user.getName(), user.getStartingWeight(), user.getCurrentWeight(),
                user.getGoalWeight(), user.getWeeklyCaloriesIntake(),
                user.getDailyCaloriesIntake(), user.getDailyProtein(),
                user.getDailyFat(), user.getDailyCarbohydrate());
    }

    public List<UserSimpleData> getUsers() {
        List<UserSimpleData> users = new ArrayList<>();
        userEntityRepository.findAll().forEach(user -> users.add(getUserData(user.getName())));
        return users;
    }

    private void createDefault() {
        if (userEntityRepository.getByName("Bartek").isEmpty()) {
            userEntityRepository.save(
                    new UserEntity(
                            "Bartek",
                            89.9,
                            82.0,
                            16100,
                            2300,
                            100,
                            30,
                            60
                    )
            );
        }
        if (userEntityRepository.getByName("Gosia").isEmpty()) {
            userEntityRepository.save(
                    new UserEntity(
                            "Gosia",
                            71.0,
                            65.0,
                            12600,
                            1800,
                            70,
                            30,
                            60
                    )
            );
        }
    }

    public DayOfEatingEntity getDay(Long dayId) {
        var userId = getUserIdFromDayId(dayId);
        if (!userEntityRepository.existsById(userId)) {
            throw new IllegalArgumentException("there is no user with that id: " + userId);
        }
        if (!dayOfEatingService.existById(dayId)) {
            var user = userEntityRepository.getById(userId);
            List<WeekEntity> x;
            var dateFromId = dayOfEatingService.getDateFormId(dayId);
            var todayDay = LocalDate.now().getDayOfWeek();
            if (user.getWeeks().isEmpty()) {
                x = List.of(weekEntityService.addNewWeek(dayId, user.getWeeklyCaloriesIntake()));
            } else if (dateFromId.getDayOfWeek() == DayOfWeek.MONDAY && todayDay != DayOfWeek.SUNDAY) {
                if (!dayOfEatingService.isDayBeforeExist(dayId)) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                } else {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can only creat next week on Sunday!");
                }
            } else {
                x = user.getWeeks();
                x.add(weekEntityService.addNewWeek(dayId, user.getWeeklyCaloriesIntake()));
            }

            userEntityRepository.save(new UserEntity(
                    userId, user.getName(), user.getStartingWeight(), user.getCurrentWeight(), user.getGoalWeight(),
                    user.getWeeklyCaloriesIntake(), user.getDailyCaloriesIntake(), user.getDailyProtein(), user.getDailyFat(),
                    user.getDailyCarbohydrate(), x));
        }
        return dayOfEatingService.getDay(dayId);
    }

    private Long getUserIdFromDayId(Long dayId) {
        return Long.parseLong(dayId.toString().substring(0, dayId.toString().length() - 8));
    }

    public boolean createNewWeek(Long userId) {
        var user = userEntityRepository.getById(userId);
        var todayId = Long.parseLong(userId + LocalDate.now().toString().replace("-", ""));
        if (!dayOfEatingService.existById(todayId)) {
            var weeks = user.getWeeks();
            weeks.add(weekEntityService.addNewWeek(todayId, user.getWeeklyCaloriesIntake()));
            return true;
        } else return false;

    }
}