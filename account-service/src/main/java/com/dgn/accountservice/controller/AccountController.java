package com.dgn.accountservice.controller;

import com.dgn.accountservice.model.Account;
import com.dgn.accountservice.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/addAccount")
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.addAccount(account), HttpStatus.CREATED);
    }
    @GetMapping("/getAllAccount")
    public ResponseEntity<List<Account>> getAllAccount(){
        return new ResponseEntity<>(accountService.getAllAccount(),HttpStatus.OK);
    }

    @GetMapping("/getAllAccountEurekaServer")
    public ResponseEntity<List<Account>> getAllAccountEurekaServer(){
        return new ResponseEntity<>(accountService.getAllAccountEurekaServer(),HttpStatus.OK);
    }
}
