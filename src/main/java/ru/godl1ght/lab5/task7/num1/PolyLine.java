package ru.godl1ght.lab5.task7.num1;

import java.util.List;

public class PolyLine {
    private List<Point> points;

    //конструктор
    public PolyLine(List<Point> points) {
        this.points = points;
    }

    // метод представления в строке
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");

        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i).toString());

            if (i < points.size() - 1) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

    //“Линия [Т1,T2,…,TN]”, где TN – это
    //результат приведения к строке Точки с номером N
}
