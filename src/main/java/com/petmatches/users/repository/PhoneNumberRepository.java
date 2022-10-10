package com.petmatches.users.repository;

import com.petmatches.users.model.PhoneNumberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumberModel, Long> {
}
