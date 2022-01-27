package com.example.gosiabartekroadtoweeding.Controller;

import com.example.gosiabartekroadtoweeding.Ingredient.IngredientDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.gosiabartekroadtoweeding.utilty.TestIngredientDtoBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IngredientControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void thereAreDefaultIngredients() throws Exception {
        var ingredients = performGetIngredientsNames().andReturn().getResponse().getContentAsString();
        assertThat(ingredients).contains("apple", "yeast flakes");
    }

    @Test
    void cannotAddIngredientWithNameThatExistInDB() throws Exception {
                performAddIngredient(TestIngredientDtoBuilder.existingOne().build())
                .andExpect(status().isBadRequest());
    }

    @Test
    void addingIngredientSucceed() throws Exception {
                performAddIngredient(TestIngredientDtoBuilder.newIngredient("ham").build())
                        .andExpect(status().isOk());
    }

    @Test
    void ingredientNameListHasNewAddedIngredient() throws Exception {
        performAddIngredient(TestIngredientDtoBuilder.newIngredient("walnut").build())
                .andExpect(status().isOk());

        var ingredients = performGetIngredientsNames().andReturn().getResponse().getContentAsString();
        assertThat(ingredients).contains("walnut");
    }

    private ResultActions performAddIngredient(IngredientDto ingredient) throws Exception{
        return mockMvc.perform(MockMvcRequestBuilders.post("/addIngredient")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(wrapIngredient(ingredient)));
    }

    private ResultActions performGetIngredientsNames() throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.get("/getIngredientsList")).andExpect(status().isOk());
    }

    private String wrapIngredient(IngredientDto ingredient) throws JsonProcessingException {
        return objectMapper.writeValueAsString(ingredient);
    }
}