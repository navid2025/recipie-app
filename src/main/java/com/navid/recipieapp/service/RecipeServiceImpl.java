package com.navid.recipieapp.service;

import com.navid.recipieapp.domain.Recipe;
import com.navid.recipieapp.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author n.zare 2/8/2023 $
 */

@Service
public class RecipeServiceImpl implements RecipeService{

 RecipeRepository recipeRepository;

 public RecipeServiceImpl(RecipeRepository recipeRepository) {
  this.recipeRepository = recipeRepository;
 }

 @Override
 public Set<Recipe> getRecipes() {
  Set<Recipe> recipes = new HashSet<>();
  recipeRepository.findAll().forEach(recipes::add);
  return recipes;
 }

 public Recipe getRecipeById(long id) {

  return recipeRepository.findById(id).isPresent() ? recipeRepository.findById(id).get():null;
 }
}
