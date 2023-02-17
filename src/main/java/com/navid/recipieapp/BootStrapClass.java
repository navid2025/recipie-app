package com.navid.recipieapp;

import com.navid.recipieapp.domain.*;
import com.navid.recipieapp.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author n.zare 2/6/2023 $
 */
@Component
public class BootStrapClass implements ApplicationRunner {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final NotesRepository notesRepository;
    private final IngredientRepository ingredientRepository;
    private final UnitOfMeasuresRepository unitOfMeasuresRepository;

    public BootStrapClass(RecipeRepository recipeRepository, CategoryRepository categoryRepository,
                          NotesRepository notesRepository, IngredientRepository ingredientRepository,
                          UnitOfMeasuresRepository unitOfMeasuresRepository) {

        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.notesRepository = notesRepository;
        this.ingredientRepository = ingredientRepository;
        this.unitOfMeasuresRepository = unitOfMeasuresRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        initialize();
    }



    public void initialize() throws Exception{
        Optional<UnitOfMeasures> eachOptional = unitOfMeasuresRepository.findByUom("Each");
        Optional<UnitOfMeasures> tablespoonOptional = unitOfMeasuresRepository.findByUom("Tablespoon");
        Optional<UnitOfMeasures> teaSpoonOptional = unitOfMeasuresRepository.findByUom("Teaspoon");
        Optional<UnitOfMeasures> dashOptional = unitOfMeasuresRepository.findByUom("Dash");
        Optional<UnitOfMeasures> pintOptional = unitOfMeasuresRepository.findByUom("Pint");
        Optional<UnitOfMeasures> cupOptional = unitOfMeasuresRepository.findByUom("Cup");

        if (!eachOptional.isPresent()){
            throw new RuntimeException("Each is not present in DB");
        }
        UnitOfMeasures eachUom = eachOptional.get();

        if (!tablespoonOptional.isPresent()){
            throw new RuntimeException("tablespoon is not present in DB");
        }
        UnitOfMeasures tablespoon = tablespoonOptional.get();

        if (!teaSpoonOptional.isPresent()){
            throw new RuntimeException("teaSpoon is not present in DB");
        }
        UnitOfMeasures teaSpoon = teaSpoonOptional.get();

        if (!dashOptional.isPresent()){
            throw new RuntimeException("dash is not present in DB");
        }
        UnitOfMeasures dash = dashOptional.get();

        if (!cupOptional.isPresent()){
            throw new RuntimeException("cup is not present in DB");
        }
        UnitOfMeasures cup = cupOptional.get();

        if (!pintOptional.isPresent()){
            throw new RuntimeException("pint is not present in DB");
        }
        UnitOfMeasures pint = pintOptional.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByCategoryName("American");
        Optional<Category> mexicanCategoryOptional = categoryRepository.findByCategoryName("Mexican");
        Optional<Category> italianCategoryOptional = categoryRepository.findByCategoryName("Italian");


        if (!americanCategoryOptional.isPresent()){
            throw new RuntimeException("americanCategory is not present in DB");
        }
        Category americanCategory = americanCategoryOptional.get();

        if (!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("mexicanCategory is not present in DB");
        }
        Category mexicanCategory = mexicanCategoryOptional.get();

        if (!italianCategoryOptional.isPresent()){
            throw new RuntimeException("italianCategory is not present in DB");
        }
        Category italianCategory = italianCategoryOptional.get();
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.Easy);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

        Note guacNotes  = new Note();
        guacNotes.setNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");

        guacRecipe.setNotes(guacNotes);


        Ingredient ing1 = new Ingredient();
        ing1.setAmount(Double.valueOf(2));
        ing1.setDescription("ripe avocados");
        ing1.setUnitOfMeasure(eachUom);

        Ingredient ing2 = new Ingredient();
        ing2.setAmount(Double.valueOf(5));
        ing2.setDescription("Kosher salt");
        ing2.setUnitOfMeasure(teaSpoon);

        Ingredient ing3 = new Ingredient();
        ing3.setAmount(Double.valueOf(2));
        ing3.setDescription("fresh lime juice or lemon juice");
        ing3.setUnitOfMeasure(tablespoon);

        Ingredient ing4 = new Ingredient();
        ing4.setAmount(Double.valueOf(2));
        ing4.setDescription("minced red onion or thinly sliced green onion");
        ing4.setUnitOfMeasure(tablespoon);

        Ingredient ing5 = new Ingredient();
        ing5.setAmount(Double.valueOf(2));
        ing5.setDescription("serrano chiles, stems and seeds removed, minced");
        ing5.setUnitOfMeasure(eachUom);

        Ingredient ing8 = new Ingredient();
        ing8.setAmount(Double.valueOf(2));
        ing8.setDescription("Cilantro");
        ing8.setUnitOfMeasure(tablespoon);

        Ingredient ing7 = new Ingredient();
        ing7.setAmount(Double.valueOf(2));
        ing7.setDescription("freshly grated black pepper");
        ing7.setUnitOfMeasure(dash);

        Ingredient ing6 = new Ingredient();
        ing6.setAmount(Double.valueOf(5));
        ing6.setDescription("ripe tomato, seeds and pulp removed, chopped");
        ing6.setUnitOfMeasure(eachUom);

        guacRecipe.addIngredient(ing1);
        guacRecipe.addIngredient(ing2);
        guacRecipe.addIngredient(ing3);
        guacRecipe.addIngredient(ing4);
        guacRecipe.addIngredient(ing5);
        guacRecipe.addIngredient(ing6);
        guacRecipe.addIngredient(ing7);
        guacRecipe.addIngredient(ing8);

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);


        guacRecipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacRecipe.setServings("2");
        guacRecipe.setSource("Simply Recipes");

        recipeRepository.save(guacRecipe);

    }


}
