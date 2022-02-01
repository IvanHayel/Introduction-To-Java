package com.epam.introduction.aggregation_and_composition.task_4;

public class Task4 {
    public static void main(String[] args) {
        BankAccount firstAccount = new BankAccount();
        BankAccount secondAccount = new BankAccount();
        BankAccount thirdAccount = new BankAccount();

        thirdAccount.withdraw(123);

        System.out.println();
        Customer customer = new Customer();
        customer.addBankAccount(firstAccount);
        customer.addBankAccount(secondAccount);
        customer.addBankAccount(thirdAccount);
        System.out.println(customer);

        firstAccount.topUp(230.12);
        firstAccount.block();
        firstAccount.withdraw(100);
        System.out.println(customer);

        secondAccount.withdraw(504.29);
        thirdAccount.topUp(2000);
        thirdAccount.withdraw(1231);
        System.out.println(customer);

        BankAccount requiredAcccount = customer.searchBankAccount(3);
        System.out.println("The account you are looking for: ");
        System.out.println("Account number - " + requiredAcccount.getAccountNumber() +
                ", balance[" + requiredAcccount.getBalance() + "], " +
                "status: " + requiredAcccount.getStatus());

        System.out.println();
        customer.sortBankAccounts();
        System.out.println(customer);

        System.out.println("Total balance of customer: " + customer.getTotalBalance());
        System.out.println("Total debt: " + customer.getDebt());
        System.out.println("Total positive balance: " + customer.getPositiveBalanceAmount());

        System.out.println();
        customer.searchBankAccount(1).unblock();
        System.out.println(customer);
    }
}