package com.spring.data.bug.demo.api;

import com.spring.data.bug.demo.model.User;
import com.spring.data.bug.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Users {

    private UserService userService;

    public Users(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User getOne(@PathVariable String userId) {
        return userService.findOne(userId);
    }
}
