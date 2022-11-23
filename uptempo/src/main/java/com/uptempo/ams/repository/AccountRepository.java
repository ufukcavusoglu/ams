package com.uptempo.ams.repository;

import com.uptempo.ams.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    Optional<Account> findByEmail(String email);

    List<Account> findByMarkedForDeletion(Boolean isMarkedForDeletion);

}
