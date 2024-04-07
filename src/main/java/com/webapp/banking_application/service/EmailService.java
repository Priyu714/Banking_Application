package com.webapp.banking_application.service;

import java.util.concurrent.CompletableFuture;

public interface EmailService {

    public CompletableFuture <Void> sendEmail(String to, String subject,String text);

    public String getOtpLoginEmailTemplat(String name, String accountNumber,String otp);
}
