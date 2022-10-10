package com.petmatches.users.service;

import com.petmatches.users.enums.RolName;
import com.petmatches.users.model.RoleModel;

import java.util.List;
import java.util.Optional;

public interface RolService {

 RoleModel saveRole(RoleModel roleModel);

    Optional<RoleModel> getByNameRole(RolName roleUser);
}
