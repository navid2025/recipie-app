package com.navid.recipieapp.controller;

import com.navid.recipieapp.domain.Recipe;
import com.navid.recipieapp.exception.NotFoundException;
import com.navid.recipieapp.repository.RecipeRepository;
import com.navid.recipieapp.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

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
 @RequestMapping("/recipe/find/{id}")
 public String getRecipeById(@PathVariable String id, Model model) {
  if(id instanceof String){
   throw new NumberFormatException();
  }

  Recipe recipe = recipeService.getRecipeById(Long.valueOf(id));
  if (recipe != null) {

   model.addAttribute("recipe", recipe);
  }
  else throw new NotFoundException("NOT FOUND");

  return "recipe/show";
 }

 @ResponseStatus(HttpStatus.NOT_FOUND)
 @ExceptionHandler(NotFoundException.class)
 public ModelAndView notFoundException(){
  ModelAndView mv = new ModelAndView();
  mv.setViewName("exception/not-found-exception");
  return mv;
 }
 @ResponseStatus(HttpStatus.BAD_REQUEST)
 @ExceptionHandler(NumberFormatException.class)
 public ModelAndView numberFormatExceptionHandler(){
  ModelAndView mv = new ModelAndView();
  mv.setViewName("exception/number-format-exception");
  return mv;
 }

}
