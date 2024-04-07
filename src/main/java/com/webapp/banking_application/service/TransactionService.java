package com.webapp.banking_application.service;

import com.webapp.banking_application.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {

    List<TransactionDTO> getAllTransactionsByAccountNumber(String accountNumber);
}
