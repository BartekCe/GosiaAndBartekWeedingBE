package com.example.gosiabartekroadtoweeding.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
    Optional<IngredientEntity> getByName(String name);

    boolean existsByName(String name);
}
