package com.webapp.banking_application.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository<Transaction, Long>{

    //Add any custom query methhos here if needed

    List<Transaction> findBySourceAccount_AccountNumberOrTargetAccount_AccountNumber(String sourceAccountNumber, String targetAccountNumber);
}
