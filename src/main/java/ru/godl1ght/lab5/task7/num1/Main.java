package ru.godl1ght.lab5.task7.num1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // лист со списком точек
        List<Point> points = Arrays.asList(
                new Point(1, -2),
                new Point(1, -2),
                new Point(3, 4),
                new Point(3, -5),
                new Point(0, 1),
                new Point(2, -3)
        );

        // использование .stream
        PolyLine polyLine = points
                .stream()
                // убираем дубликаты
                .distinct()
                // преобразуем у в положительное значение
                .map(point -> new Point(point.getX(), Math.abs(point.getY())))
                // сортировка по х
                .sorted(Comparator.comparingDouble(Point::getX))
                // собираем все элементы в список
                .collect(Collectors.collectingAndThen(Collectors.toList(), PolyLine::new));

        System.out.println(polyLine);
    }
}
