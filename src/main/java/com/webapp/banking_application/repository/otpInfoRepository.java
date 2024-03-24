package com.webapp.banking_application.repository;

import com.webapp.banking_application.entity.OtpInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface otpInfoRepository extends JpaRepository<OtpInfo, Long> {
}
