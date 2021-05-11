package com.recipetrackingapp.recipetrackingapp.controllers;

import com.recipetrackingapp.recipetrackingapp.models.Recipe;
import com.recipetrackingapp.recipetrackingapp.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping
    public String displayAllRecipes(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/index";
    }

    @GetMapping("create")
    public String displayCreateRecipeForm(Model model) {
        model.addAttribute("title", "Create Recipe");
        model.addAttribute(new Recipe());
        return "recipes/create";
    }

    @PostMapping("create")
    public String processCreateRecipeForm(@ModelAttribute @Valid Recipe newRecipe, Errors errors, Model model) {

        if (errors.hasErrors()){
            model.addAttribute("title", "Create Recipe");
            return "recipes/create";
        }

        recipeRepository.save(newRecipe);
        return "redirect:";


    }
}
