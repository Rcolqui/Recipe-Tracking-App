package com.recipetrackingapp.recipetrackingapp.models;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "recipes")
public class Recipe extends AbstractEntity {

    @NotEmpty
    @Size(min=3, max=65, message = "Recipe name must be between 3 and 65 characters long")
    private String name;

    //Need to think of a reasonable max size for this
    private String description;

    //Need to think of a reasonable max size for this
    private String ingredients;

    //Need to think of a reasonable max size for this
    private String instructions;

    public Recipe(String name, String description, String ingredients, String instructions) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Recipe() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
