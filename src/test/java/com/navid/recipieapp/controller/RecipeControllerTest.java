package com.navid.recipieapp.controller;


import com.navid.recipieapp.service.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author n.zare 2/8/2023 $
 */
@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @InjectMocks
    RecipeController recipeController;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        recipeController = new RecipeController(recipeService);
        mockMvc = standaloneSetup(recipeController).build();
    }

    @Test
    void numberOfCalls() {
        verify(recipeService, times(0)).getRecipes();
    }

    @Test
    void getIndex(){
        Assertions.assertEquals(recipeController.getRecipe(model), "recipe/index");
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }

    @Test
    void findRecipesTest() throws Exception{
        mockMvc.perform(get("/")).andExpect(status().is(200)).andExpect(view().name("recipe/index"));
    }
    @Test
    void findRecipeById() throws Exception {
        mockMvc.perform(get("/recipe/find/1")).andExpect(status().isOk()).andExpect(view().name("recipe/show"));

    }
}