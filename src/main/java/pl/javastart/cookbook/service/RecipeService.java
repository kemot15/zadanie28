package pl.javastart.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.javastart.cookbook.entity.Category;
import pl.javastart.cookbook.entity.Recipe;
import pl.javastart.cookbook.repository.RecipeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> filterByCategory (Category category){
        return recipeRepository.findAll().stream()
                .filter(recipe -> recipe.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<Recipe> filter5MostLiked (){
        return recipeRepository.findAll().stream()
                .sorted(Comparator.comparing(Recipe::getRating).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}
