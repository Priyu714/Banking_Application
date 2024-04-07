package com.webapp.banking_application.dto;

public class AccountResponse {

    private String accountNumber;
    private Double balance;
    private String accountType;
    private String IFSCCode;
    private String branch;

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public String getIFSCCode() {
        return IFSCCode;
    }
    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
}
