package ru.godl1ght.lab5.task7.num1;

public class Line {
    private Point start;
    private Point end;

    // конструктор
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // гетеры

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Линия от " + start.toString() + " до " + end.toString();
    }
}
