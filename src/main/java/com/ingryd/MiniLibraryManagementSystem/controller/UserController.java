package com.ingryd.MiniLibraryManagementSystem.controller;

import com.ingryd.MiniLibraryManagementSystem.model.User;
import com.ingryd.MiniLibraryManagementSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable int id){
        return userService.findUserById(id).getBody();
    }
    @GetMapping("user/all")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }
    @PostMapping("/user")
    public User postUser(@RequestBody @Valid User user){
        return userService.saveUser(user);
    }
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody @Valid User user){
        return userService.updateUser(id, user);
    }
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable int id){
        return userService.deleteUser(id);
    }
}
