package com.epam.introduction.aggregation_and_composition.task_4;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<BankAccount> bankAccounts = new ArrayList<>();

    public void addBankAccount(BankAccount bankAccount) {
        bankAccount.setOwner(this);
        bankAccounts.add(bankAccount);
    }

    public BankAccount searchBankAccount(int accountNumber) {
        for (BankAccount account : bankAccounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new IllegalArgumentException("Costumer doesn't have access to this account.");
    }

    public void sortBankAccounts() {
        bankAccounts.sort((account, anotherAccount) -> (int) (anotherAccount.getBalance() - account.getBalance()));
    }

    public double getTotalBalance() {
        double totalBalance = 0;
        for (BankAccount account : bankAccounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public double getDebt() {
        double debt = 0;
        for (BankAccount account : bankAccounts) {
            if (account.getBalance() < 0) {
                debt += account.getBalance();
            }
        }
        return debt * (-1);
    }

    public double getPositiveBalanceAmount() {
        double amount = 0;
        for (BankAccount account : bankAccounts) {
            if (account.getBalance() > 0) {
                amount += account.getBalance();
            }
        }
        return amount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Customer status\n");
        builder.append("Number of bank accounts: " + bankAccounts.size() + '\n');
        int counter = 0;
        for (BankAccount account : bankAccounts) {
            builder.append(++counter);
            builder.append(". Account number " + account.getAccountNumber() + ',');
            builder.append(" balance[" + account.getBalance() + "], ");
            builder.append("status: " + account.getStatus() + ";\n");
        }
        return builder.toString();
    }
}