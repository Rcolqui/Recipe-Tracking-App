package com.recipetrackingapp.recipetrackingapp.controllers;

import com.recipetrackingapp.recipetrackingapp.models.User;
import com.recipetrackingapp.recipetrackingapp.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

//Needs work
    @GetMapping
    public String displayLoginForm(Model model) {
        model.addAttribute(new User());
        return "user/login";
    }
//Needs work
    @PostMapping
    public String processLoginForm(Model model, @ModelAttribute @Valid User user, Errors errors, String password) {

        if (user.getPassword().equals(password) && !errors.hasErrors()) {
            return "recipes/index";
        }
        else {
            model.addAttribute("error", "The password or username is incorrect");
            return "user/login";
        }
    }

    @GetMapping("user/add")
    public String displayAddUserForm(Model model) {

        model.addAttribute(new User());
        return "user/add";
    }

    //Clicking create new recipe button results in errors involving this method
    @PostMapping("user/add")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {

        if (user.getPassword().equals(verify) && !errors.hasErrors()) {
            return "recipes/index";
        }
        else {
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        }
    }
}



