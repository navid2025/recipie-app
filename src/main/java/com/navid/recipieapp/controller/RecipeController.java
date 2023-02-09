package com.navid.recipieapp.controller;

import com.navid.recipieapp.repository.RecipeRepository;
import com.navid.recipieapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author n.zare 2/8/2023 $
 */

@Controller
public class RecipeController {

 RecipeService recipeService;

 public RecipeController(RecipeService recipeService) {
  this.recipeService = recipeService;
 }

 @RequestMapping({"","/","index"})
 public String getRecipe(Model model){
  model.addAttribute("recipes", recipeService.getRecipes());
  return "recipe/index";
 }
}
