package com.example.gosiabartekroadtoweeding.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
        Optional<RecipeEntity> findByName(String name);
        Optional<RecipeEntity> getByName(String name);
}
