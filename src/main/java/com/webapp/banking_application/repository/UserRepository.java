package com.webapp.banking_application.repository;

import com.webapp.banking_application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String Email);

    User findByAccountAccountNumber(String accountNumber);
}
