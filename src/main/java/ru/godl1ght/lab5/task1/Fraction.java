package ru.godl1ght.lab5.task1;

public class Fraction implements FractionInterface {
    private int numerator;
    private int denominator;
    private Double cachedValue = null;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public double getDecimalValue() {
        if (cachedValue == null) {
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        cachedValue = null; // Обнуляем кеш
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        if (denominator < 0) {
            this.numerator = -this.numerator;
            denominator = -denominator;
        }
        this.denominator = denominator;
        cachedValue = null; // Обнуляем кеш
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // если ссылки равны
        // если obj == null или классы не совпадают (другого типа)
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction fraction = (Fraction) obj;
        // логическое равенство
        return this.numerator * fraction.denominator == this.denominator * fraction.numerator;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(numerator) * 31 + Integer.hashCode(denominator);
        // Умножение на 31 можно представить как (n << 5) - n
        // (сдвиг на 5 бит влево минус исходное число).
    }
}
