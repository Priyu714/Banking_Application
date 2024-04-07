package com.webapp.banking_application.service;

import com.webapp.banking_application.entity.User;

public interface UserService {
    public User registerUser(User user);
    User getUserByAccountNumber(String accountNumber);

    public void saveUser(User user);

    User updateUser(User user);
}
