package ru.godl1ght.lab5.task1;

public class Main {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(-6, -8);

        // Проверка корректности
        FractionUtils.validateFraction(fraction1);
        FractionUtils.validateFraction(fraction2);

        System.out.println(fraction1); // 3/4
        System.out.println(FractionUtils.getDecimalValue(fraction1)); // 0.75
        System.out.println(FractionUtils.areEqual(fraction1, fraction2)); // true

        System.out.println(FractionUtils.generateHashCode(fraction1));
    }
}

