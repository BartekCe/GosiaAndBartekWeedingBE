package com.example.gosiabartekroadtoweeding.Meal.Week;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekEntityRepository extends JpaRepository<WeekEntity, Long> {
}
