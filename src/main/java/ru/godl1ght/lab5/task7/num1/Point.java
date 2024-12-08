package ru.godl1ght.lab5.task7.num1;

public class Point {
    private double x;
    private double y;

    // конструктор
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // гетеры
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // метод для отображения
    @Override
    public String toString() {
        return String.format("{%.2f;%.2f}", x, y);
    }
}
