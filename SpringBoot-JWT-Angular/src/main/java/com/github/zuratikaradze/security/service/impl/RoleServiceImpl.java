package com.github.zuratikaradze.security.service.impl;


import com.github.zuratikaradze.security.model.AppUser;
import com.github.zuratikaradze.security.model.Role;
import com.github.zuratikaradze.security.repository.AppUserRepository;
import com.github.zuratikaradze.security.repository.RoleRepository;
import com.github.zuratikaradze.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public List<Role> getRoleList() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getOne(id);
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void updateRole(Role role, Long id) {
//        Role newRole = roleRepository.getOne(id);
//        newRole.setName(role.getName());
        role.setId(id);
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        // როლის წასაშლელად ჯერ ყველა იუზერს უნდა მოვაშორო ეს როლი და მერე წავშალო.
        Role role = roleRepository.getOne(id); // ვიღებთ როლის ობიექტს
        List<AppUser> appUsers = appUserRepository.findAllByRoles(role);// მოგვაქ ყველა იუზერი რომელსაც აქვს ეს როლი
        for (AppUser appUser : appUsers) {
            appUser.getRoles().remove(role); // მოვაძრობთ ამ როლს იუზერებს
            System.out.println(appUser.getUsername() + "-ს წავუშალე როლი : " + role.getName());
        }
        roleRepository.delete(role); // წავშლით როლს
        System.out.println("როლი წარმატებით წაიშალა");
    }
}
