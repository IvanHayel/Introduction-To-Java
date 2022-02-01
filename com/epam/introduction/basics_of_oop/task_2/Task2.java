package com.epam.introduction.basics_of_oop.task_2;

/**
 * Create a Payment class with an inner class that can be used to create a purchase from several products.
 */

public class Task2 {
    public static void main(String[] args) {
        Payment payment = new Payment();

        payment.displayPrice();

        System.out.println();
        payment.addGem(Gem.BERYL);
        payment.addGem(Gem.BERYL);
        payment.addGem(Gem.DIAMOND);
        payment.addGem(Gem.AMETHYST);
        payment.addGem(Gem.AQUAMARINE);
        payment.addGem(Gem.AQUAMARINE);
        payment.addGem(Gem.AQUAMARINE);
        payment.displayPrice();

        System.out.println();
        payment.removeGem(Gem.BERYL);
        payment.removeGem(Gem.AQUAMARINE);
        payment.removeGem(Gem.AQUAMARINE);
        payment.removeGem(Gem.AQUAMARINE);
        payment.addGem(Gem.RUBY);
        payment.displayPrice();
    }
}