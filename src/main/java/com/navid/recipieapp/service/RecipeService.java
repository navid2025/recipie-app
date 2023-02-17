package com.navid.recipieapp.service;

import com.navid.recipieapp.domain.Recipe;

import java.util.Optional;
import java.util.Set;

/**
 * @author n.zare 2/8/2023 $
 */

public interface RecipeService {
  Set<Recipe> getRecipes();
  Recipe getRecipeById(long id);

}
