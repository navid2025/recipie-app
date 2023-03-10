package com.navid.recipieapp.repository;

import com.navid.recipieapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * @author n.zare 2/6/2023 $
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
