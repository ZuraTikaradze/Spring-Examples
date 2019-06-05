package com.github.zuratikaradze.security.repository;

import com.github.zuratikaradze.security.model.AppUser;
import com.github.zuratikaradze.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);

    List<AppUser> findAllByRoles(Role role);
}
