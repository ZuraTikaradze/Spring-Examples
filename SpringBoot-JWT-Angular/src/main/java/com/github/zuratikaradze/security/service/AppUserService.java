package com.github.zuratikaradze.security.service;

import com.github.zuratikaradze.security.model.AppUser;
import com.github.zuratikaradze.security.model.Role;

import java.util.List;

public interface AppUserService {
    List<AppUser> getUserList();

    AppUser getUserById(Long id);

    AppUser addUser(AppUser appUser);

    void updateUser(AppUser appUser, Long id);

    void deleteUser(Long id);
}
