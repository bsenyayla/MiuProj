package com.eregistrar.miueregistrar.service.impl;


import com.eregistrar.miueregistrar.model.Role;
import com.eregistrar.miueregistrar.repository.RoleRepository;
import com.eregistrar.miueregistrar.service.RoleService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll(Sort.by("name"));
    }

}
