package methods.task_17;

/*
 * Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр
 * и т.д. Сколько таких действий надо произвести, чтобы получился нуль?
 * Для решения задачи использовать декомпозицию.
 */

public class Task17 {
    public static void main(String[] args) {
        int number = 5678;
        int actionsQuantity = getActionsQuantity(number);
        System.out.println("Given number: " + number);
        System.out.println("Actions quantity to reach zero: " + actionsQuantity);
    }

    private static int getActionsQuantity(int number) {
        int sumOfDigits = getSumOfDigits(number);
        int actionsQuantity = 0;
        while (number >= 0) {
            number -= sumOfDigits;
            actionsQuantity++;
        }
        return actionsQuantity;
    }

    private static int getSumOfDigits(int number) {
        int sumOfDigits = 0;
        while (number != 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }
        return sumOfDigits;
    }
}
