package com.navid.recipieapp.controller;

import com.navid.recipieapp.domain.Category;
import com.navid.recipieapp.domain.UnitOfMeasures;
import com.navid.recipieapp.repository.UnitOfMeasuresRepository;
import com.navid.recipieapp.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author n.zare 2/6/2023 $
 */
@Controller
public class IndexController {
    CategoryRepository categoryRepository;
    UnitOfMeasuresRepository unitOfMeasureRepository;
    private final UnitOfMeasuresRepository unitOfMeasuresRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasuresRepository unitOfMeasureRepository,
                           UnitOfMeasuresRepository unitOfMeasuresRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasuresRepository = unitOfMeasuresRepository;
    }

//    @RequestMapping({"", "/", "/index"})
//    public String index(){
//        Optional<Category> queryCategory= categoryRepository.findByCategoryName("french");
//        System.out.println("************" + queryCategory.get().getId());
//        Optional<UnitOfMeasures> queryCategory2= unitOfMeasuresRepository.findByUom("Pintch");
//        System.out.println(queryCategory2.get().getId());
//        return "index1";
//    }
}
