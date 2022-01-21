package com.example.gosiabartekroadtoweeding.Meal;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimple;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    List<IngredientSimple> ingredients;
    private int calories;


    public MealEntity(List<IngredientSimple> ingredients, Long id, int calories) {
        this.id = id;
        this.calories = calories;
        this.ingredients = ingredients;

    }

    public MealEntity(List<IngredientSimple> ingredients){
        this.calories = 0;
        this.ingredients = ingredients;
    }
}
