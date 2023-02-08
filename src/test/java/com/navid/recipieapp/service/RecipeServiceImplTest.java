package com.navid.recipieapp.service;

import com.navid.recipieapp.domain.Recipe;
import com.navid.recipieapp.repository.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author n.zare 2/8/2023 $
 */

class RecipeServiceImplTest {

   RecipeServiceImpl recipeServiceImpl;

   @Mock
   RecipeRepository recipeRepository;


  @BeforeEach
  void setUp() {
   MockitoAnnotations.openMocks(this);
   recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
   Recipe recipe = new Recipe();
   Set<Recipe> recipes  = new HashSet<>();
   recipes.add(recipe);
   Mockito.when(recipeRepository.findAll()).thenReturn(recipes);

  }

  @Test
  void getRecipes() {
   Assertions.assertEquals(recipeServiceImpl.getRecipes().size(), 1);

  }
}