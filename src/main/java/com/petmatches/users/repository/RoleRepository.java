package com.petmatches.users.repository;

import com.petmatches.users.enums.RolName;
import com.petmatches.users.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleModel, Long > {
    Optional<RoleModel> findByRolName(RolName rolName);
}
