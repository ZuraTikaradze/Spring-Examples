package com.github.zuratikaradze.security.service;

import com.github.zuratikaradze.security.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleList();

    Role getRoleById(Long id);

    void addRole(Role role);

    void updateRole(Role role, Long id);

    void deleteRole(Long id);
}
