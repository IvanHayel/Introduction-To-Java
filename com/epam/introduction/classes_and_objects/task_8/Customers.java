package com.epam.introduction.classes_and_objects.task_8;

import java.util.Arrays;

public class Customers {
    private Customer[] customers;

    public Customers(Customer[] customers) {
        this.customers = customers.clone();
    }

    public void printCustomers(Customer[] customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void printCustomersAlphabetically() {
        Customer[] copyCustomers = customers.clone();
        Arrays.sort(copyCustomers, (customer, anotherCustomer) -> {
            String customerFullName = customer.getCustomerSurname() + customer.getCustomerName() +
                    customer.getCustomerPatronymic();
            String anotherCustomerFullName = anotherCustomer.getCustomerSurname() + anotherCustomer.getCustomerName() +
                    anotherCustomer.getCustomerPatronymic();
            return customerFullName.compareTo(anotherCustomerFullName);
        });
        printCustomers(copyCustomers);
    }

    public void printCustomersByCardRange(long from, long to) {
        long cardValue;
        for (Customer customer : customers) {
            cardValue = Long.parseLong(customer.getCustomerCardNumber());
            if (cardValue >= from && cardValue <= to) {
                System.out.println(customer);
            }
        }
    }
}