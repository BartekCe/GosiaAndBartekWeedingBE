package com.example.gosiabartekroadtoweeding.Ingredient;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal protein;
    @NotNull
    private  BigDecimal fat;
    @NotNull
    private  BigDecimal carbohydrate;
    @NotNull
    private int grams;


    public boolean withoutNulls(){
        System.out.println(this);
        return Stream.of(this.name,this.protein,this.fat,this.carbohydrate,this.grams)
                .allMatch(Objects::nonNull);
    }
    @Override
    public String toString() {
        return "IngredientDto{" +
                "name='" + name + '\'' +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate +
                ", grams=" + grams +
                '}';
    }
}