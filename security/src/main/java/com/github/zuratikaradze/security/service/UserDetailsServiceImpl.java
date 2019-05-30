package com.github.zuratikaradze.security.service;

import com.github.zuratikaradze.security.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // ჩაჰარდკოდებული მომხმარებლების სია დაშიფრული პაროლებით.
        final List<AppUser> users = Arrays.asList(
                new AppUser(1, "zura", encoder.encode("12345"), "USER"),
                new AppUser(2, "admin", encoder.encode("12345"), "ADMIN")
        );

        for (AppUser appUser : users) {
            if (appUser.getUsername().equals(username)) {
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());
                return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
            }
        }
        // თუ იუზერი არ მოიძებნა ვისვრით ექსეფშენს
        throw new UsernameNotFoundException("Username: " + username + " not found");
    }

}