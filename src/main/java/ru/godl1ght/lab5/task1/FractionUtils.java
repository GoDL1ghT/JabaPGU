package ru.godl1ght.lab5.task1;

public class FractionUtils {
    static Double cachedValue = null;

    // Проверка корректности знаменателя
    public static void validateFraction(Fraction fraction) {
        if (fraction.getDenominator() <= 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
    }

    // Вычисление вещественного значения с кешированием
    public static double getDecimalValue(Fraction fraction) {
        if (cachedValue == null) {
            System.out.println("1");
            cachedValue = (double) fraction.getNumerator() / fraction.getDenominator();
        }
        return cachedValue;
    }

    // Сравнение дробей
    public static boolean areEqual(Fraction f1, Fraction f2) {
        return f1.getNumerator() * f2.getDenominator() == f2.getNumerator() * f1.getDenominator();
    }

    // Генерация хеша
    public static int generateHashCode(Fraction fraction) {
        return Integer.hashCode(fraction.getNumerator()) * 31 + Integer.hashCode(fraction.getDenominator());
    }
}