package com.example.basic_banking_app.Data;

import java.util.SplittableRandom;

public class Transaction {
    private String fromUser;
    private String toUser;
    private int amount;
    private int status1;

    public Transaction(String fromName, String toName, int accountBalance, int status) {
        this.fromUser = fromName;
        toUser = toName;
        amount = accountBalance;
        status1 = status;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStatus1() {
        return status1;
    }

    public void setStatus1(int status1) {
        this.status1 = status1;
    }
}


