package com.festuskerich.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import com.festuskerich.tutorial.dto.User;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureGraphQlTester
public class UserControllerTest {

    @Autowired
    private GraphQlTester tester;

    @Test
    public void testUsersQuery() {
        String query = "{users {id name address}}";
        List<User> user = tester.document(query)
                .execute()
                .path("data.users[*]")
                .entityList(User.class)
                .get();
        Assertions.assertTrue(user.size() > 0);
        Assertions.assertEquals(1, user.get(0).id());

    }
}
