package com.navid.recipieapp.repository;

import com.navid.recipieapp.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author n.zare 2/6/2023 $
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
