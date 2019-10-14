package pl.javastart.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.cookbook.entity.Component;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Component, Long> {


    List<Component> findAllByRecipe(Long recipId);
}
