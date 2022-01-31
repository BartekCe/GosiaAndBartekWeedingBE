package com.example.gosiabartekroadtoweeding.Ingredient;

import lombok.Getter;

import java.util.List;

@Getter
public class DefaultIngredients {
    private final List<IngredientEntity> defaultIngredients;

    public DefaultIngredients() {
        this.defaultIngredients = createDefault();
    }

    private List<IngredientEntity> createDefault(){
        return List.of(
                new IngredientEntity(
                        "oat flakes",
                        10.87,
                        5.77,
                        75.6
                ),
                  new IngredientEntity(
                        "chia seeds",
                        20.0,
                        33.33,
                        33.33
                ),
                 new IngredientEntity(
                        "onion",
                        0.92,
                        0.08,
                        10.11
                ),
                 new IngredientEntity(
                        "oil",
                        0.0,
                        100.0,
                        0.0
                ),
                 new IngredientEntity(
                        "butter",
                        0.85,
                        81.11,
                        0.06
                ),
                 new IngredientEntity(
                        "apple",
                        0.26,
                        0.17,
                        13.81
                ),
                 new IngredientEntity(
                        "yeast flakes",
                        50.0,
                        0.0,
                        70.0
                ),
                 new IngredientEntity(
                        "potato",
                        1.66,
                        2.4,
                        19.36
                ),
                 new IngredientEntity(
                        "soy milk(Natumi)",
                        3.5,
                        2.1,
                        2.0
                ),
                 new IngredientEntity(
                        "skyr natural",
                        12.0,
                        0.0,
                        3.8
                ),
                 new IngredientEntity(
                        "cream cheese(delikate)",
                        6.0,
                        23.0,
                        3.0
                ),
                 new IngredientEntity(
                        "tofu(bio, Berief)",
                        14.0,
                        7.0,
                        0.5
                ),
                 new IngredientEntity(
                        "avocado",
                        1.33,
                        16.0,
                        8.0
                ),
                 new IngredientEntity(
                        "banana",
                        1.09,
                        0.33,
                        22.84
                ),
                 new IngredientEntity(
                        "canned white beans(240g)",
                        8.2,
                        0.6,
                        12.0
                ),
                 new IngredientEntity(
                        "canned tomatoes(400g)",
                        1.1,
                        0.0,
                        3.2
                ),
                 new IngredientEntity(
                        "pasta(Barilla)",
                        12.8,
                        2.0,
                        70.9
                ),
                 new IngredientEntity(
                        "vegan mayo",
                        0.0,
                        30.0,
                        9.2
                ),
                 new IngredientEntity(
                        "egg(1 ~ 60g)",
                        12.58,
                        9.94,
                        0.77
                ),
                 new IngredientEntity(
                        "peanut butter(go vege)",
                        26.2,
                        51.9,
                        9.6
                ),new IngredientEntity(
                        "walnuts",
                        15.0,
                        65.0,
                        14.0
                )
                ,new IngredientEntity(
                        "cooked white beans",
                        10.22,
                        0.76,
                        21.92
                )
        );
    }
}
