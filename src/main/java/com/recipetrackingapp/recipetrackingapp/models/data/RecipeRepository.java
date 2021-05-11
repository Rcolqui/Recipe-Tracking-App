package com.recipetrackingapp.recipetrackingapp.models.data;

import com.recipetrackingapp.recipetrackingapp.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}

