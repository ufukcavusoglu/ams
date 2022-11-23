package com.uptempo.ams.service;

import com.uptempo.ams.model.entity.Account;
import com.uptempo.ams.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
    }

    @Transactional
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account findById(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    public List<Account> findByIsMarkedForDeletion(Boolean isMarkedForDeletion) {
        return accountRepository.findByMarkedForDeletion(isMarkedForDeletion);
    }
}
