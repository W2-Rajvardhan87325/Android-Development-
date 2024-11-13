package com.sunbeam.mobilesapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.mobilesapp.dtos.Credentials;
import com.sunbeam.mobilesapp.dtos.ShopResult;
import com.sunbeam.mobilesapp.entities.User;
import com.sunbeam.mobilesapp.services.UserService;

@CrossOrigin
@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ShopResult<?> getAllUsers() {
        List<User> list = userService.findAllUsers();
        return ShopResult.success(list);
    }

    @GetMapping("/users/{id}")
    public ShopResult<?> getUserById(@PathVariable("id") int id) {
        User user = userService.findUserById(id);
        return ShopResult.success(user);
    }

    @GetMapping("/users/email/{email}")
    public ShopResult<?> getUserByEmail(@PathVariable("email") String email) {
        User user = userService.findUserByEmail(email);
        return ShopResult.success(user);
    }

    @PostMapping("/users/login")
    public ShopResult<?> userLogin(@RequestBody Credentials cr) {
        User user = userService.findUserByEmailAndPassword(cr.getEmail(), cr.getPassword());
        if(user == null)
            return ShopResult.error("Invalid credentials");
        return ShopResult.success(user);
    }

    @PostMapping("/users")
    public ShopResult<?> userRegister(@RequestBody User u) {
        User du = userService.saveUser(u);
        return ShopResult.success(du);
    }

    @PutMapping("/users/{id}")
    public ShopResult<?> userUpdate(@PathVariable("id") int id, @RequestBody User u) {
        u.setId(id);
        User du = userService.saveUser(u);
        return ShopResult.success(du);
    }

    @DeleteMapping("/users/{id}")
    public ShopResult<?> deleteUserById(@PathVariable("id") int id) {
        int count = userService.deleteUserById(id);
        return ShopResult.success(count);
    }
}
