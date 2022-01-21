package com.example.gosiabartekroadtoweeding.DayOfEating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayOfEatingRepository extends JpaRepository<DayOfEatingEntity, Long> {
    DayOfEatingEntity getById(Long id);
}
