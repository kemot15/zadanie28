package pl.javastart.cookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.cookbook.entity.Category;
import pl.javastart.cookbook.entity.Recipe;
import pl.javastart.cookbook.repository.ComponentRepository;
import pl.javastart.cookbook.repository.RecipeRepository;

import javax.swing.plaf.LabelUI;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class RecipeController {
    RecipeRepository recipeRepository;
    ComponentRepository componentRepository;


    public RecipeController(RecipeRepository recipeRepository, ComponentRepository componentRepository) {
        this.recipeRepository = recipeRepository;
        this.componentRepository = componentRepository;
    }

    @GetMapping ("/recipe/{id}")
    public String showRecipe (Model model, @PathVariable Long id){
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (recipeOptional.isPresent()){
            Recipe recipe = recipeOptional.get();
            model.addAttribute("recipe", recipe);
            return "recipe";
        }
        else
            return "home";
    }

    @GetMapping("/dodaj")
    public String addRecipe (Model model, @RequestParam (required = false) Long przepis) {
        Recipe recipe;
        if (przepis != null){
            Optional<Recipe> recipeOptional = recipeRepository.findById(przepis);
            recipe = recipeOptional.get();
        }
        else
        {
            recipe = new Recipe();
        }
        Category[] categories = Category.values();
        model.addAttribute("recipe", recipe );
        model.addAttribute("categories", categories);
        return "dodajPrzepis";
    }

    @PostMapping("/dodaj")
    public String addRecipe (Recipe recipe) {
        recipeRepository.save(recipe);
        return "dodajPrzepis";
    }

    @GetMapping("/edytujPrzepis")
    public String editRecipe (Model model, @RequestParam Long przepis){
        Optional<Recipe> recipeOptional = recipeRepository.findById(przepis);
        Recipe recipe = recipeOptional.get();
        Category[] categories = Category.values();
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", categories);
        return "edytujPrzepis";
    }

    @PostMapping("/edytujPrzepis")
    public String editRecipe (Recipe recipe){
        recipeRepository.save(recipe);
        return "redirect:/recipe/" + recipe.getId();
    }

    @GetMapping("/usunPrzepis")
    public String deleteRecip(@RequestParam Long przepis) {
        recipeRepository.deleteById(przepis);
        return "redirect:/";
    }

    @GetMapping("/lubieTo")
    public String likeIt(@RequestParam Long przepis) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(przepis);
        Recipe recipe = recipeOptional.get();
        int rating = recipe.getRating()+1;
        recipe.setRating(rating);
        recipeRepository.save(recipe);
        return "redirect:/recipe/"+ recipe.getId();
    }

    @GetMapping("/ranking")
    public String showRank (Model model){
        List<Recipe> rankingPrzepisow = recipeRepository.findAll().stream()
                .sorted(Comparator.comparing(Recipe::getRating).reversed())
                .limit(5)
                .collect(Collectors.toList());//recipeService.filter5MostLiked();
        model.addAttribute("rankingPrzepisow", rankingPrzepisow);
        return "ranking";
    }

}
