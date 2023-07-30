package com.festuskerich.tutorial.dto;

import java.util.Arrays;
import java.util.List;

public record User(Integer id, String name,String address) {

        private static List<User> books = Arrays.asList(
            new User(1, "Effective Java", "author-1"),
            new User(2, "Hitchhiker's Guide to the Galaxy", "author-2"),
            new User(3, "Down Under", "author-3")
    );

    public static User getById(Integer id) {
        return books.stream()
				.filter(user -> user.id().equals(id))
				.findFirst()
				.orElse(null);
    }
    public static List<User> users(){
        return books;
    }
    
}
