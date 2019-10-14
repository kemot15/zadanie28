package pl.javastart.cookbook.controller;

import org.dom4j.rule.Mode;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.cookbook.GeneratorDanych;
import pl.javastart.cookbook.entity.Category;
import pl.javastart.cookbook.entity.Component;
import pl.javastart.cookbook.entity.Recipe;
import pl.javastart.cookbook.repository.ComponentRepository;
import pl.javastart.cookbook.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private static final String[] NAZWA = {"Niesamowity", "Smaczny", "Dobry", "Słaby", "Pyszny", "Wyjątkowy"};
    private static final String[] TITLE = {"spaghetti", "krokiety", "salatka", "burger", "krewetki", "sernik", "makowiec", "sushi"};
    private static final String[] SKLADNIK = {"cukier", "sol", "pieprz", "makaron", "ryz", "maka", "woda", "olej"};


    RecipeRepository recipeRepository;
    ComponentRepository componentRepository;
    //List<Recipe> recipes;

    public HomeController(RecipeRepository recipeRepository, ComponentRepository componentRepository) {
        this.recipeRepository = recipeRepository;
        this.componentRepository = componentRepository;
        generator();
    }

    @GetMapping("/")
    public String home (Model model, @RequestParam (required = false) Category category){
        List<Recipe> recipes = recipeRepository.findAll();
        if (category!=null){
            recipes = recipes.stream()
                            .filter(recipe -> recipe.getCategory().equals(category))
                            .collect(Collectors.toList());
            Category cat = category;
            model.addAttribute("cat", cat);
        }
        Category[] categories = Category.values();
        model.addAttribute("categories", categories);
        model.addAttribute("recipes", recipes);
        return "home";
    }

    public void generator() {
        Random random = new Random();

        List<Recipe> recipeList = new ArrayList<Recipe>();
        List<Component> components = new ArrayList<Component>();
        Category[] categories = Category.values();
        for (int i = 1; i < 100 ; i++){
            Recipe recipe = new Recipe();
            recipe.setName(NAZWA[random.nextInt(NAZWA.length)] + " " + TITLE[random.nextInt(TITLE.length)]);
            recipe.setDescription("\"Lorem ipsum dolor sit amet, consectetur adipiscing");
            int time = random.nextInt(200);
            time = time - time%10;
            recipe.setPrepareTime(time);
            recipe.setPerson(random.nextInt(7)+1);
            recipe.setRating(random.nextInt(1000));
            recipe.setCategory(categories[random.nextInt(categories.length)]);
            recipeList.add(recipe);
        }
        recipeRepository.saveAll(recipeList);
        for (int j = 1; j < 300; j++){
            Component component = new Component();
            component.setComponentName(SKLADNIK[random.nextInt(SKLADNIK.length)]);
            component.setRecipe(recipeList.get(random.nextInt(98)+1));
            component.setQuantity(random.nextInt(100000)/100);
            components.add(component);
        }
        componentRepository.saveAll(components);
    }
}
