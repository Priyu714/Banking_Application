package com.webapp.banking_application.service;

import com.webapp.banking_application.entity.Account;
import com.webapp.banking_application.entity.User;
import com.webapp.banking_application.exception.NotFoundException;
import com.webapp.banking_application.repository.AccountRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account createAccount(User user) {
        String accountNumber =generateUniqueAccountNumber();
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(0.0);
        return accountRepository.save(account);
    }

    private String generateUniqueAccountNumber() {
        String accountNumber;

        // Generate a UUID as the account number
        do {
            accountNumber = UUID.randomUUID().toString().replaceAll("-","").substring(0,6);
        }while(accountRepository.findByAccountNumber(accountNumber)!=null);

        return accountNumber;
    }

    @Override
    public boolean isPinCreated(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if(account == null)
            throw new NotFoundException("Account not found");

        return account.getPin()!=null;
    }

    @Override
    public void createPIN(String accountNumber, String password, String pin) {

    }

    @Override
    public void updatedPIN(String accountNumber, String oldPIN, String password, String newPIN) {

    }

    @Override
    public void cashWithdrawal(String accountNumber, String pin, double amount) {

    }

    @Override
    public void cashDeposit(String accountNumber, String pin, double amount) {

    }

    @Override
    public void fundTransper(String sourceAccountNumber, String targetAccountNumber, String pin, double amount) {

    }
}
