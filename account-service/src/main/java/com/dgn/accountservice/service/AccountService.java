package com.dgn.accountservice.service;

import com.dgn.accountservice.model.Account;
import com.dgn.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final RestTemplate restTemplate;

    @Value("${DOGAN}")
    private String result;

    public AccountService(AccountRepository accountRepository, RestTemplate restTemplate) {
        this.accountRepository = accountRepository;
        this.restTemplate = restTemplate;
    }

    public Account addAccount(Account account){
        return accountRepository.save(account);
    }

    public List<Account> getAllAccount(){
        System.out.println(result);
        return accountRepository.findAll();
    }

    public List<Account> getAllAccountEurekaServer(){
//        String url = "http://localhost:8282/account/getAllAccount";
        String url = "http://ACCOUNT-SERVICE/account/getAllAccount";


//        final Account[] accounts = restTemplate.getForObject(url, Account[].class);
        final List accountList = restTemplate.getForObject(url, List.class);

        return accountList;
    }
}
