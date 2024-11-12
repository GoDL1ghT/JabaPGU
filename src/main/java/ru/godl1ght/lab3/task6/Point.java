package ru.godl1ght.lab3.task6;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        // Проверка на допустимость значений координат x и y
        if (Double.isNaN(x) || Double.isNaN(y)) {
            throw new IllegalArgumentException("Координаты X и Y не могут быть NaN.");
        }
        if (x < -1000 || x > 1000 || y < -1000 || y > 1000) {
            throw new IllegalArgumentException("Координаты должны быть в диапазоне от -1000 до 1000.");
        }

        this.x = x;
        this.y = y;
    }

    public String getCoordinates() {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    public static void main(String[] args) {
        try {
            Point point1 = new Point(3, 5);
            Point point2 = new Point(25, 6);
            Point point3 = new Point(7, 8);

            System.out.println(point1.getCoordinates());
            System.out.println(point2.getCoordinates());
            System.out.println(point3.getCoordinates());

            // Пример сравнения двух точек
            Point point4 = new Point(3, 5);
            System.out.println("point1 равен point4: " + point1.equals(point4));

            // Пример создания точки с некорректными координатами для проверки
            Point invalidPoint = new Point(Double.NaN, 100); // Должен вызвать исключение
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

