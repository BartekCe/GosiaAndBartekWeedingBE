package com.example.gosiabartekroadtoweeding.Ingredient;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimple;
import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimpleDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class IngredientServiceTest {
    
    @Autowired
    private IngredientService ingredientService;

//    IngredientDto soyMilk = new IngredientDto("soyMilk", BigDecimal.valueOf(4.7), BigDecimal.valueOf(2), BigDecimal.valueOf(2.4), 100);
//    IngredientDto oat = new IngredientDto("oat", BigDecimal.valueOf(8.8), BigDecimal.valueOf(1.2), BigDecimal.valueOf(60), 100);
//    IngredientDto nuts = new IngredientDto("nuts", BigDecimal.valueOf(18), BigDecimal.valueOf(19), BigDecimal.valueOf(16), 100);
//
//    List<IngredientDto> ingredients = List.of(soyMilk,oat,nuts);
//
//    List<IngredientSimpleDto> simpleIngredients = List.of(
//            new IngredientSimpleDto("soyMilk", 200, 1),
//            new IngredientSimpleDto("oat", 100, 2 ),
//            new IngredientSimpleDto( "nuts", 100, 3)
//    );

    @Test
    void qweqeqweqew() {

        Long id = 2420100410L;
        var x = id.toString().substring(2);
        System.out.println(x.substring(0,4));
        System.out.println(x.substring(4,6));
        System.out.println(x.substring(6));

    }
}