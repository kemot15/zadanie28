package pl.javastart.cookbook;

import pl.javastart.cookbook.entity.Category;
import pl.javastart.cookbook.entity.Component;
import pl.javastart.cookbook.entity.Recipe;
import pl.javastart.cookbook.repository.RecipeRepository;

import java.util.List;
import java.util.Random;

public class GeneratorDanych {

//    private static final String[] NAZWA = {"Niesamowity", "Smaczny", "Dobry", "Słaby", "Pyszny", "Wyjątkowy"};
//    private static final String[] TITLE = {"spaghetti", "krokiety", "salatka", "burger", "krewetki", "sernik", "makowiec", "sushi"};
//    private static final String[] SKLADNIK = {"cukier", "sol", "pieprz", "makaron", "ryz", "maka", "woda", "olej"};

    RecipeRepository recipeRepository;

    public GeneratorDanych(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

//    public void generator() {
//        Random random = new Random();
//        Recipe recipe = new Recipe();
//        List<Recipe> recipeList = null;
//        Category[] categories = Category.values();
//
//        for (int i = 1; i < 1000 ; i++){
//            recipeList.clear();
//            recipe.setId((long) i);
//            recipe.setName(NAZWA[random.nextInt(NAZWA.length)] + " " + TITLE[random.nextInt(TITLE.length)]);
//            recipe.setDescription("\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
//            recipe.setPrepareTime(random.nextInt(200));
//            recipe.setPerson(random.nextInt(8));
//            recipe.setRating(random.nextInt(1000));
//            recipe.setCategory(categories[random.nextInt(categories.length)]);
//            List<Component> components = null;
//            int quantityComponents = random.nextInt(15);
//            Component component = new Component();
//
//            for (int j = 1; j < quantityComponents; j++){
//                component.setComponentName(SKLADNIK[random.nextInt(SKLADNIK.length)]);
//                component.setId((long)j);
//                component.setRecipe(recipe);
//                component.setQuantity(random.nextInt(100000)/100);
//                components.add(component);
//            }
//            recipe.setComponents(components);
//            recipeList.add(recipe);
//        }
//        recipeRepository.saveAll(recipeList);
//
//
//    }
}
