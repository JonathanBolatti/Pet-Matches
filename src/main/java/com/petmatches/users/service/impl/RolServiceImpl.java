package com.petmatches.users.service.impl;

import com.petmatches.users.enums.RolName;
import com.petmatches.users.model.RoleModel;
import com.petmatches.users.repository.RoleRepository;
import com.petmatches.users.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("rolService")
public class RolServiceImpl implements RolService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public RoleModel saveRole(RoleModel roleModel) {
        return roleRepository.save(roleModel);
    }

    @Override
    public Optional<RoleModel> getByNameRole(RolName rolName) {
        return roleRepository.findByRolName(rolName);
    }
}
