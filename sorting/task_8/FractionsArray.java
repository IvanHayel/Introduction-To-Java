package sorting.task_8;

import java.util.TreeMap;

public class FractionsArray {
    private final TreeMap<Double, Fraction> fractions;

    FractionsArray(int[] numerators, int[] denominators) {
        this.fractions = new TreeMap<>();
        for (int counter = 0; counter < numerators.length; counter++) {
            Fraction fraction = new Fraction(numerators[counter], denominators[counter]);
            fractions.put(fraction.getValue(), fraction);
        }
    }

    public void leadToCommonDenominator() {
        int commonDenominator = getCommonDenominator();
        for (Fraction currentFraction : fractions.values()) {
            int currentDenominator = currentFraction.getDenominator();
            int currentNumerator = currentFraction.getNumerator();
            int increase = commonDenominator / currentDenominator;
            currentFraction.setNumerator(currentNumerator * increase);
            currentFraction.setDenominator(commonDenominator);
        }

    }

    private int getCommonDenominator() {
        int commonDenominator = fractions.firstEntry().getValue().getDenominator();
        for (Fraction currentFraction : fractions.values()) {
            int currentDenominator = currentFraction.getDenominator();
            commonDenominator = getLeastCommonMultiple(commonDenominator, currentDenominator);
        }
        return commonDenominator;
    }

    private int getLeastCommonMultiple(int firstValue, int secondValue) {
        int leastCommonMultiple = firstValue * secondValue;
        int greatestCommonDivisor = getGreatestCommonDivisor(firstValue, secondValue);
        return leastCommonMultiple / greatestCommonDivisor;
    }

    private int getGreatestCommonDivisor(int firstValue, int secondValue) {
        while (firstValue != secondValue) {
            if (firstValue > secondValue) {
                int tempValue = firstValue;
                firstValue = secondValue;
                secondValue = tempValue;
            }
            secondValue = secondValue - firstValue;
        }
        return firstValue;
    }

    @Override
    public String toString() {
        return fractions.values().toString();
    }
}
