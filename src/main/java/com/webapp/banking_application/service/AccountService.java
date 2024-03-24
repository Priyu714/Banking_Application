package com.webapp.banking_application.service;

import com.webapp.banking_application.entity.Account;
import com.webapp.banking_application.entity.User;

public interface AccountService {

    public Account createAccount(User user);

    public boolean isPinCreated(String accountNumber);

    public void createPIN(String accountNumber, String password ,String pin );

    public void updatedPIN(String accountNumber, String oldPIN, String password, String newPIN);

    public void cashWithdrawal(String accountNumber, String pin, double amount);

    public void cashDeposit(String accountNumber, String pin, double amount);

    public void fundTransper(String sourceAccountNumber, String targetAccountNumber,String pin, double amount);




}
