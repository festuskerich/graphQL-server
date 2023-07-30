package com.festuskerich.tutorial.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.festuskerich.tutorial.dto.User;

@Controller
public class UserQueryController {
    @QueryMapping
    public User userById(@Argument Integer id) {
        return User.getById(id);
    }

    @QueryMapping
    public List<User> users() {
        return User.users();
    }

}
