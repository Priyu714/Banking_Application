package com.webapp.banking_application.service;

import com.webapp.banking_application.entity.Account;
import com.webapp.banking_application.exception.UserValidation;
import com.webapp.banking_application.util.LoggedinUser;
import com.webapp.banking_application.entity.User;
import com.webapp.banking_application.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, AccountService accountService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
        String encodedpassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedpassword);

        // Save the user details
        User savedUser =userRepository.save(user);

        Account account = accountService.createAccount(savedUser);
        savedUser.setAccount(account);
        userRepository.save(savedUser);

        System.out.println(savedUser.getAccount().getAccountNumber());
        System.out.println(account.getUser().getName());

        return savedUser;
    }

    @Override
    public User getUserByAccountNumber(String accountNumber) {
        return userRepository.findByAccountAccountNumber(accountNumber);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User existingUser =userRepository.findByAccountAccountNumber(LoggedinUser.getAccountNumber());

        if(user.getEmail() != null){
            if(user.getEmail().isEmpty())
                throw new UserValidation("Email can't be empty");
            else
                existingUser.setEmail(user.getEmail());
        }

        if(user.getName() != null){
            if(user.getName().isEmpty())
                throw new UserValidation("Name can't be empty");
            else
                existingUser.setName(user.getName());
        }
        if(user.getPhone_number() != null){
            if(user.getPhone_number().isEmpty())
                throw new UserValidation("Phone Number can't be empty");
            else
                existingUser.setPhone_number(user.getPhone_number());
        }
        if(user.getAddress() != null){
            if(user.getAddress().isEmpty())
                throw new UserValidation("Address can't be Empty");
            else
                existingUser.setAddress(user.getAddress());
        }
        return userRepository.save(existingUser);
    }
}
