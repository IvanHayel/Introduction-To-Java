package sorting.task_8;

/*
 * Даны дроби с натуральными числителями и знаменателями.
 * Составить программу, которая приводит эти дроби к общему знаменателю
 * и упорядочивает их по возрастанию.
 */

public class Task8 {
    public static void main(String[] args) {
        int[] numerators = {2, 2, -1, 3, 4, 5, -22, -31};
        int[] denominators = {2, -3, 2, 1, -3, 12, 2, -3};
        FractionsArray fractionsArray = new FractionsArray(numerators, denominators);
        System.out.println(fractionsArray);
        fractionsArray.leadToCommonDenominator();
        System.out.println(fractionsArray);
    }
}