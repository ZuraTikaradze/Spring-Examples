package com.github.zuratikaradze.security.controller;

import com.github.zuratikaradze.security.model.AppUser;
import com.github.zuratikaradze.security.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    AppUserService appUserService;

    @GetMapping("/users")
    public List<AppUser> getUsers() {
        return appUserService.getUserList();
    }

    @GetMapping("/user/{id}")
    public AppUser getUser(@PathVariable Long id) {
        return appUserService.getUserById(id);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody AppUser user) {
        appUserService.addUser(user);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@RequestBody AppUser appUser, @PathVariable Long id) {
        appUserService.updateUser(appUser, id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        appUserService.deleteUser(id);
    }
}
