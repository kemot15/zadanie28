package pl.javastart.cookbook.controller;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.cookbook.entity.Component;
import pl.javastart.cookbook.entity.Recipe;
import pl.javastart.cookbook.repository.ComponentRepository;
import pl.javastart.cookbook.repository.RecipeRepository;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ComponentController {

    ComponentRepository componentRepository;
    RecipeRepository recipeRepository;

    public ComponentController(ComponentRepository componentRepository, RecipeRepository recipeRepository) {
        this.componentRepository = componentRepository;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping ("/dodajSkladnik")
    public String addComponent (Model model, @RequestParam Long przepis){
        Component component = new Component();
        component.setRecipe(recipeRepository.findById(przepis).orElse(null));
        model.addAttribute("component", component);
        model.addAttribute("recipe", recipeRepository.findAll());
        return "dodajSkladnik";
    }

    @PostMapping ("/dodajSkladnik")
    public String addComponent (Component component) {
       componentRepository.save(component);
        return "redirect:/dodaj?przepis=" + component.getRecipe().getId();
    }

    @GetMapping ("/edytujSkladnik")
    public String editComponent (Model model, @RequestParam Long skladnik){
        Component component = componentRepository.getOne(skladnik);
        model.addAttribute("component", component);
        return "edytujSkladnik";
    }

    @PostMapping ("/edytujSkladnik")
    public String editComponent (Component component) {
        if (component.getQuantity() == 0 || component.getComponentName()=="")
        componentRepository.delete(component);
        else
            componentRepository.save(component);
        return "redirect:/edytujPrzepis?przepis=" + component.getRecipe().getId();
    }

}
