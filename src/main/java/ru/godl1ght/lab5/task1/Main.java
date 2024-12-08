package ru.godl1ght.lab5.task1;

public class Main {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(-6, -8);

        System.out.println(fraction1); // 3/4
        System.out.println(fraction1.getDecimalValue()); // 0.75
        System.out.println(fraction1.equals(fraction2)); // true

        fraction1.setNumerator(5);
        fraction1.setDenominator(10);
        System.out.println(fraction1); // 5/10
        System.out.println(fraction1.getDecimalValue()); // 0.5
    }
}

