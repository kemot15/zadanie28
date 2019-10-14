package pl.javastart.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.cookbook.GeneratorDanych;
import pl.javastart.cookbook.entity.Recipe;

import javax.validation.constraints.Null;
import java.util.List;

public interface RecipeRepository extends JpaRepository <Recipe, Long> {





}
