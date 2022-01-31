package com.example.gosiabartekroadtoweeding.Recipe;

import com.example.gosiabartekroadtoweeding.IngrediantSimple.IngredientSimpleDto;
import com.example.gosiabartekroadtoweeding.Ingredient.IngredientDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RecipeServiceTest {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void asdasdasf() throws Exception {
        var recipeDto = new RecipeDto("oat meal", List.of(
                new IngredientSimpleDto("oat flakes", 70, 1),
                new IngredientSimpleDto("soy milk(Natumi)", 180, 2)));

        mockMvc.perform(MockMvcRequestBuilders.post("/addRecipe")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(wrapIngredient(recipeDto))).andExpect((status().isOk()));

        recipeService.getRecipe("oat meal");

        mockMvc.perform(MockMvcRequestBuilders.get("/getRecipe/oat meal")
        ).andExpect((status().isOk()));
    }

    private String wrapIngredient(RecipeDto recipeDto) throws JsonProcessingException {
        return objectMapper.writeValueAsString(recipeDto);
    }
}