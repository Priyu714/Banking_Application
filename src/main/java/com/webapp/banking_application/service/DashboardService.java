package com.webapp.banking_application.service;
import com.webapp.banking_application.dto.AccountResponse;
import com.webapp.banking_application.dto.UserResponse;

public interface DashboardService {
    UserResponse getUserDetails(String accountNumber);
    AccountResponse getAccountDetails(String accountNumber);
}
