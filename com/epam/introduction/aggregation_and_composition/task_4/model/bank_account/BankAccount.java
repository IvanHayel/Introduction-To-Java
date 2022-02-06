package com.epam.introduction.aggregation_and_composition.task_4.model.bank_account;

import com.epam.introduction.aggregation_and_composition.task_4.model.customer.Customer;

public class BankAccount {
    private static int nextAccountNumber = 1;

    private final int ACCOUNT_NUMBER;
    private double balance;
    private boolean isBlocked;
    private Customer owner;

    public BankAccount() {
        ACCOUNT_NUMBER = nextAccountNumber++;
        balance = 0;
        isBlocked = false;
    }

    public void block() {
        isBlocked = true;
    }

    public void unblock() {
        isBlocked = false;
    }

    public void withdraw(double amount) {
        if (isBlocked || owner == null) {
            System.out.println("Withdraw denied!");
        } else {
            balance -= amount;
        }
    }

    public void topUp(double amount) {
        if (isBlocked || owner == null) {
            System.out.println("Top up denied!");
        } else {
            balance += amount;
        }
    }

    public int getAccountNumber() {
        return ACCOUNT_NUMBER;
    }

    public double getBalance() {
        return balance;
    }

    public String getStatus() {
        if (isBlocked) {
            return "blocked";
        } else {
            return "available";
        }
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}