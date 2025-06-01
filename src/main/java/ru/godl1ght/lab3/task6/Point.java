package ru.godl1ght.lab3.task6;

/**
 * Класс, представляющий точку в двумерном пространстве с координатами (x, y).
 * Координаты должны быть в диапазоне от -1000 до 1000 и не могут быть NaN.
 */
public class Point {
    private final double x;
    private final double y;

    /**
     * Создает новую точку с указанными координатами.
     *
     * @param x координата по оси X
     * @param y координата по оси Y
     * @throws IllegalArgumentException если координаты выходят за допустимые пределы или являются NaN
     */
    public Point(double x, double y) {
        if (Double.isNaN(x) || Double.isNaN(y)) {
            throw new IllegalArgumentException("Координаты X и Y не могут быть NaN.");
        }
        if (x < -1000 || x > 1000 || y < -1000 || y > 1000) {
            throw new IllegalArgumentException("Координаты должны быть в диапазоне от -1000 до 1000.");
        }

        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает строковое представление координат точки в формате {x;y}.
     *
     * @return строковое представление координат
     */
    public String getCoordinates() {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    /**
     * Демонстрация работы с классом Point.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        try {
            Point point1 = new Point(3, 5);
            Point point2 = new Point(25, 6);
            Point point3 = new Point(7, 8);

            System.out.println(point1.getCoordinates());
            System.out.println(point2.getCoordinates());
            System.out.println(point3.getCoordinates());

            Point point4 = new Point(3, 5);
            System.out.println("point1 равен point4: " + point1.equals(point4));

            Point invalidPoint = new Point(Double.NaN, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}