package com.recipetrackingapp.recipetrackingapp.models.data;

import com.recipetrackingapp.recipetrackingapp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}