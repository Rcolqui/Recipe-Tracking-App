package com.recipetrackingapp.recipetrackingapp.controllers;

import com.recipetrackingapp.recipetrackingapp.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {


    @GetMapping
    public String displayLoginForm(Model model) {
        model.addAttribute(new User());
        return "login";
    }

    @PostMapping
    public String processLoginForm(Model model, @ModelAttribute @Valid User user, Errors errors, String password) {

        if (user.getPassword().equals(password) && !errors.hasErrors()) {
            return "recipe-index";
        }
        else {
            model.addAttribute("error", "The password or username is incorrect");
            return "login";
        }
    }

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {

        model.addAttribute(new User());
        return "add";
    }

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {

        if (user.getPassword().equals(verify) && !errors.hasErrors()) {
            return "recipe-index";
        }
        else {
            model.addAttribute("error", "Passwords do not match");
            return "add";
        }
    }
}



