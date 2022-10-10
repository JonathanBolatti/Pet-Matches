package com.petmatches.users.repository;

import com.petmatches.users.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    Boolean existsByUsername(String username);

    Optional<UserModel> findByUsername(String username);

}
