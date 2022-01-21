package com.example.gosiabartekroadtoweeding.Recipe;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimple;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<IngredientSimple> ingredients;

    public RecipeEntity(String name, List<IngredientSimple> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }
}