package com.epam.introduction.basics_of_oop.task_2;

import com.epam.introduction.basics_of_oop.task_2.model.gem.Gem;
import com.epam.introduction.basics_of_oop.task_2.model.payment.Payment;

/**
 * Create a Payment class with an inner class that can be used to create a purchase from several products.
 */

public class Runner {
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