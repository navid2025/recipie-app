package com.navid.recipieapp.controller;


import com.navid.recipieapp.service.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author n.zare 2/8/2023 $
 */

class RecipeControllerTest {

    RecipeController recipeController;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeController = new RecipeController(recipeService);
//        Recipe recipe = new Recipe();
//        Set<Recipe> recipeSet = new HashSet<>();
//        recipeSet.add(recipe);
//        Mockito.when(recipeService).thenReturn(recipeSet);
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

    @org.junit.jupiter.api.Test
    void TestMvcController() throws Exception{
        MockMvc mockMvc = standaloneSetup(recipeController).build();
        mockMvc.perform(get("/")).andExpect(status().is(200)).andExpect(view().name("recipe/index"));
    }
}