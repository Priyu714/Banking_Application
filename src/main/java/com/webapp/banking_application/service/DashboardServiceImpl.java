package com.webapp.banking_application.service;

import com.webapp.banking_application.dto.AccountResponse;
import com.webapp.banking_application.dto.UserResponse;
import com.webapp.banking_application.entity.Account;
import com.webapp.banking_application.entity.User;
import com.webapp.banking_application.exception.NotFoundException;
import com.webapp.banking_application.repository.AccountRepository;
import com.webapp.banking_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public UserResponse getUserDetails(String accountNumber) {
        User user = userRepository.findByAccountAccountNumber(accountNumber);

        // Check if the user exists and is associated with the given account number
        if(user == null){
            throw new NotFoundException("user is not found for provided for account number");
        }

        // Map the user entity to UserResponse DTO
        UserResponse userResponse = new UserResponse();

        userResponse.setEmail(user.getEmail());
        userResponse.setName(user.getName());
        userResponse.setAccountNumber(user.getAccount().getAccountNumber());
        userResponse.setPhone_number(user.getPhone_number());
        userResponse.setAddress(user.getAddress());

        return userResponse;
    }

    @Override
    public AccountResponse getAccountDetails(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);

        if(account == null){
            throw new NotFoundException("Account is not found for provided account number");
        }

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountNumber(account.getAccountNumber());
        accountResponse.setAccountType(account.getAccount_type());
        accountResponse.setIFSCCode(account.getIFSC_code());
        accountResponse.setBranch(account.getBranch());
        accountResponse.setBalance(account.getBalance());

        return accountResponse;

    }
}
