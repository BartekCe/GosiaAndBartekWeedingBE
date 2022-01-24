package com.example.gosiabartekroadtoweeding.IngrediantSimple;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class IngredientSimple {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number;
    private int grams;
    private String name;

    public IngredientSimple(int grams, String name, int number) {
        this.grams = grams;
        this.name = name;
        this.number = number;
    }
}
