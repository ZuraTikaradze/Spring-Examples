package com.github.zuratikaradze.security.service.impl;

import com.github.zuratikaradze.security.model.AppUser;
import com.github.zuratikaradze.security.repository.AppUserRepository;
import com.github.zuratikaradze.security.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public List<AppUser> getUserList() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser getUserById(Long id) {
        return appUserRepository.getOne(id);
    }

    @Override
    public AppUser addUser(AppUser appUser) {
        System.out.println(appUser.getPassword() + " - " + encoder.encode(appUser.getPassword()));
        appUser.setPassword(encoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public void updateUser(AppUser appUser, Long id) {
        appUser.setId(id);
        appUserRepository.save(appUser);
    }

    @Override
    public void deleteUser(Long id) {
        AppUser appUser = appUserRepository.getOne(id);
        appUser.getRoles().clear();
        appUserRepository.delete(appUser);
    }
}