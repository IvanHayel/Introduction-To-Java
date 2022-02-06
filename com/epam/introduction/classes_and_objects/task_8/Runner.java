package com.epam.introduction.classes_and_objects.task_8;

import com.epam.introduction.classes_and_objects.task_8.model.customer.Customer;
import com.epam.introduction.classes_and_objects.task_8.model.customer.Customers;

/**
 * Create a Customer class whose specification is given below.
 * Define constructors, set- and get- methods, and the toString () method.
 * Create a second class that aggregates an array of type Customer, with appropriate constructors and methods.
 * Set the criteria for selecting data and display this data on the console.
 * Customer class: id, last name, first name, patronymic, address, credit card number, bank account number.
 * Find and withdraw:
 * a) a list of buyers in alphabetical order;
 * b) a list of customers whose credit card number is in a given range
 */

public class Runner {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Ivanov","Ivan",
                "Ivanovich", "438 DARK SPURT, SAN FRANCISCO");
        Customer customer2 = new Customer("Petrov","Petr","Petrovich");
        Customer customer3 = new Customer("Gagarin","Yuri","Alekseyevich");
        Customer customer4 = new Customer("Ivanov", "Boris", "Fedorovich");
        Customer[] customerArray = {customer1, customer2, customer3, customer4};

        Customers customers = new Customers(customerArray);
        customers.printCustomersAlphabetically();

        customer4.setCustomerCardNumber("1234123412341234");
        System.out.println("Customers with card numbers in range");
        System.out.println("from: 1111111111111111");
        System.out.println("to: 5555555555555555\n");
        customers.printCustomersByCardRange(1111111111111111L,5555555555555555L);
    }
}