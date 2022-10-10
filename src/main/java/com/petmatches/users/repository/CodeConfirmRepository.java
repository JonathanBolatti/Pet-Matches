package com.petmatches.users.repository;

import com.petmatches.users.model.CodeConfirmModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeConfirmRepository extends JpaRepository<CodeConfirmModel, Long> {
}
