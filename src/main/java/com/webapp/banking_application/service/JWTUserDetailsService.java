package com.webapp.banking_application.service;

import com.webapp.banking_application.entity.User;
import com.webapp.banking_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JWTUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String accountNumber) throws UsernameNotFoundException{

        User user = userRepository.findByAccountAccountNumber(accountNumber);

        if(user == null){
            throw new UsernameNotFoundException("Invalid account number");
        }

        // Return a UserDetails object that wraps the User entity
        return new org.springframework.security.core.userdetails.User(
                user.getAccount().getAccountNumber(), // Use account number as the username
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
