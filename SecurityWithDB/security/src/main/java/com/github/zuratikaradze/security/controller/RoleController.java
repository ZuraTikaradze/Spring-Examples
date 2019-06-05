package com.github.zuratikaradze.security.controller;


import com.github.zuratikaradze.security.model.Role;
import com.github.zuratikaradze.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return roleService.getRoleList();
    }

    @GetMapping("/role/{id}")
    public Role getRole(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping("/role")
    public void addRole(@RequestBody Role role) {
        roleService.addRole(role);
    }

    @PutMapping("/role/{id}")
    public void updateRole(@RequestBody Role role, @PathVariable Long id) {
        roleService.updateRole(role, id);
    }

    @DeleteMapping("/role/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

}
