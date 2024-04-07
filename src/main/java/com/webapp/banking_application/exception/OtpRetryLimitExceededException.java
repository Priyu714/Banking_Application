package com.webapp.banking_application.exception;

public class OtpRetryLimitExceededException extends RuntimeException{

    private static final long serialVersionUID = 2676963743942921043L;

    public OtpRetryLimitExceededException(String message) {
        super(message);
    }
}
