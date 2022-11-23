package com.uptempo.ams.controller;

import com.uptempo.ams.model.entity.Account;
import com.uptempo.ams.model.mapper.AccountMapper;
import com.uptempo.ams.model.request.CreateAccountRequest;
import com.uptempo.ams.model.request.UpdateAccountRequest;
import com.uptempo.ams.model.response.AccountResponse;
import com.uptempo.ams.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody CreateAccountRequest createSessionRequest){
        Account account = accountMapper.toAccount(createSessionRequest);
        account = accountService.save(account);
        AccountResponse accountResponse = accountMapper.toAccountResponse(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponse> updateAccount(@PathVariable("id") UUID id, @RequestBody UpdateAccountRequest updateAccountRequest){
        Account account = accountService.findById(id);
        accountMapper.updateAccount(updateAccountRequest, account);
        account = accountService.save(account);
        AccountResponse accountResponse = accountMapper.toAccountResponse(account);
        return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountResponse> deleteAccount(@PathVariable("id") UUID id){
        Account account = accountService.findById(id);
        account.setMarkedForDeletion(Boolean.TRUE);
        account = accountService.save(account);
        AccountResponse accountResponse = accountMapper.toAccountResponse(account);
        return ResponseEntity.ok(accountResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable("id") UUID id){
        Account account = accountService.findById(id);
        AccountResponse accountResponse = accountMapper.toAccountResponse(account);
        return ResponseEntity.ok(accountResponse);
    }

    @GetMapping("/active")
    public ResponseEntity<List<AccountResponse>> getActiveAccounts(){
        List<Account> account = accountService.findByIsMarkedForDeletion(Boolean.FALSE);
        List<AccountResponse> accountResponseList = accountMapper.toAccountResponseList(account);
        return ResponseEntity.ok(accountResponseList);
    }
}


