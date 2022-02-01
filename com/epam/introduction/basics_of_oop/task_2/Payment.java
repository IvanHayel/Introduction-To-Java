package com.epam.introduction.basics_of_oop.task_2;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    private List<GemCost> gems;
    private double price;

    public Payment() {
        gems = new ArrayList<>();
        price = 0.0;
    }

    public void addGem(Gem gem) {
        GemCost gemCost = this.new GemCost(gem);
        gems.add(gemCost);
        price += gemCost.cost;
    }

    public void removeGem(Gem gem) {
        GemCost toRemove = this.new GemCost(gem);
        if (gems.contains(toRemove)) {
            price -= toRemove.cost;
            gems.remove(toRemove);
        }
    }

    public void displayPrice() {
        if (!gems.isEmpty()) {
            System.out.println("Price list:");
            int counter = 1;
            for (GemCost gem : gems) {
                System.out.print(counter++);
                System.out.println(". " + gem);
            }
            System.out.println("Total amount = " + String.format("%.2f", price));
        } else {
            System.out.println("Price list is empty!");
        }
    }

    public class GemCost {
        private Gem gem;
        private double cost;

        public GemCost(Gem gem) {
            this.gem = gem;
            cost = setCost();
        }

        private double setCost() {
            return switch (gem) {
                case AMETHYST -> 1.19;
                case AQUAMARINE -> 8.69;
                case BERYL -> 9.99;
                case DIAMOND -> 8.59;
                case EMERALD -> 17.49;
                case GARNET -> 14.49;
                case OPAL -> 7.99;
                case RUBY -> 37.99;
                case SAPPHIRE -> 38.49;
                case TOPAZ -> 1.39;
            };
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            GemCost gemCost = (GemCost) o;

            if (Double.compare(gemCost.cost, cost) != 0) return false;
            return gem == gemCost.gem;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = gem.hashCode();
            temp = Double.doubleToLongBits(cost);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "Gem " + gem + ", cost = " + String.format("%.2f", cost) + ';';
        }
    }
}