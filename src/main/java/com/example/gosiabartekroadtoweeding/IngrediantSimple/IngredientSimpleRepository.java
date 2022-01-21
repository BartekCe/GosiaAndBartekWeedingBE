package com.example.gosiabartekroadtoweeding.IngrediantSimple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientSimpleRepository extends JpaRepository<IngredientSimple, Long> {
}
