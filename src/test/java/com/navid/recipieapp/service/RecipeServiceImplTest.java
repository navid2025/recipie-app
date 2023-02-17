package com.navid.recipieapp.service;

import com.navid.recipieapp.domain.Recipe;
import com.navid.recipieapp.repository.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

/**
 * @author n.zare 2/8/2023 $
 */
@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {


   @Mock
   RecipeRepository recipeRepository;

    @InjectMocks
    RecipeServiceImpl recipeServiceImpl;

  @BeforeEach
  void setUp() {
   recipeServiceImpl = new RecipeServiceImpl(recipeRepository);


  }

  @Test
  void getRecipes() {
   Recipe recipe = new Recipe();
   Set<Recipe> recipes  = new HashSet<>();
   recipes.add(recipe);
   when(recipeRepository.findAll()).thenReturn(recipes);
   Assertions.assertEquals(recipeServiceImpl.getRecipes().size(), 1);

  }

  @Test
  void getRecipeById(){
      Recipe mockedRecipe = new Recipe();
      mockedRecipe.setId(1L);
      when(recipeRepository.findById(1L)).thenReturn(Optional.of(mockedRecipe));
      assertEquals(recipeServiceImpl.getRecipeById(1L), mockedRecipe);

  }
}