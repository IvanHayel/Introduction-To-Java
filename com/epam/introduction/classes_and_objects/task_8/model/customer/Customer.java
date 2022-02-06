package com.epam.introduction.classes_and_objects.task_8.model.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private final int CUSTOMER_ID;

    private String customerSurname;
    private String customerName;
    private String customerPatronymic;
    private String customerAddress;
    private String customerCardNumber;
    private String customerBankAccountNumber;

    private static int nextID = 1;
    private static List<String> cardNumbers = new ArrayList<>();
    private static List<String> bankAccountNumbers = new ArrayList<>();

    public Customer(String customerSurname, String customerName, String customerPatronymic,
                    String customerAddress, String customerCardNumber, String customerBankAccountNumber) {
        this.customerSurname = customerSurname;
        this.customerName = customerName;
        this.customerPatronymic = customerPatronymic;
        this.customerAddress = customerAddress;
        this.customerCardNumber = isCorrectCardNumber(customerCardNumber) ? customerCardNumber : generateCardNumber();
        this.customerBankAccountNumber = isCorrectBankAccountNumber(customerBankAccountNumber) ?
                customerBankAccountNumber : generateBankAccountNumber();
        this.CUSTOMER_ID = nextID++;
    }

    public Customer(String customerSurname, String customerName, String customerPatronymic, String customerAddress) {
        this(customerSurname, customerName, customerPatronymic, customerAddress,
                "", "");
    }

    public Customer(String customerSurname, String customerName, String customerPatronymic) {
        this(customerSurname, customerName, customerPatronymic,
                "", "", "");
    }

    private boolean isCorrectCardNumber(String cardNumber) {
        Pattern pattern = Pattern.compile("\\d{16}");
        Matcher matcher = pattern.matcher(cardNumber);
        return matcher.find() && !cardNumbers.contains(cardNumber);
    }

    private boolean isCorrectBankAccountNumber(String bankAccountNumber) {
        Pattern pattern = Pattern.compile("\\d{18}");
        Matcher matcher = pattern.matcher(bankAccountNumber);
        return matcher.find() && !bankAccountNumbers.contains(bankAccountNumber);
    }

    private String generateCardNumber() {
        Random generator = new Random();
        StringBuilder builder = new StringBuilder();
        for (int counter = 0; counter < 16; counter++) {
            builder.append(generator.nextInt(10));
        }
        String number = builder.toString();
        if (cardNumbers.contains(number)) {
            return generateCardNumber();
        }
        cardNumbers.add(number);
        return number;
    }

    private String generateBankAccountNumber() {
        Random generator = new Random();
        StringBuilder builder = new StringBuilder();
        for (int counter = 0; counter < 18; counter++) {
            builder.append(generator.nextInt(10));
        }
        String number = builder.toString();
        if (bankAccountNumbers.contains(number)) {
            return generateBankAccountNumber();
        }
        bankAccountNumbers.add(number);
        return number;
    }

    public int getCustomerID() {
        return CUSTOMER_ID;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPatronymic() {
        return customerPatronymic;
    }

    public void setCustomerPatronymic(String customerPatronymic) {
        this.customerPatronymic = customerPatronymic;
    }

    public String getCustomerCardNumber() {
        return customerCardNumber;
    }

    public void setCustomerCardNumber(String customerCardNumber) {
        this.customerCardNumber = isCorrectCardNumber(customerCardNumber) ?
                customerCardNumber : this.customerCardNumber;
    }

    @Override
    public String toString() {
        return
                String.format("CUSTOMER %d INFO%n", CUSTOMER_ID) +
                String.format("Surname: %s%n", customerSurname) +
                String.format("Name: %s%n", customerName) +
                String.format("Patronymic: %s%n", customerPatronymic) +
                String.format("Address: %s%n", customerAddress) +
                String.format("Card number: %s%n", customerCardNumber) +
                String.format("Bank account number: %s%n", customerBankAccountNumber);
    }
}