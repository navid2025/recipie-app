package com.navid.recipieapp.repository;

import com.navid.recipieapp.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author n.zare 2/5/2023 $
 */

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByCategoryName(String category);
}
