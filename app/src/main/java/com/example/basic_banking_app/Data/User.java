package com.example.basic_banking_app.Data;

public class User {
    private int accountNumber;
    private String name;
    private String email;
    private String ifsc;
    private String phoneNo;
    private int balance;

    public User(String currentName, int accountNumber, String phoneNumber, String ifscCode, int accountBalance, String email) {
        this.name=currentName;
        this.accountNumber=accountNumber;
        this.phoneNo=phoneNumber;
        this.ifsc=ifscCode;
        this.balance=accountBalance;
        this.email=email;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


}
