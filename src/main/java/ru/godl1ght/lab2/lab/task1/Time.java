package ru.godl1ght.lab2.lab.task1;

public class Time {
    private int seconds;

    public Time(int seconds) {
        // Приведение секунд к диапазону 0-86399 (эквивалент 24 часам)
        this.seconds = seconds % 86400;
    }

    public String getFormattedTime() {
        int hours = seconds / 3600;  // Часы
        int minutes = (seconds % 3600) / 60;  // Минуты
        int secs = seconds % 60;  // Секунды

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }

    public static void main(String[] args) {
        Time time1 = new Time(10);
        Time time2 = new Time(10000);
        Time time3 = new Time(100000);

        System.out.println("Время для 10 секунд: " + time1.getFormattedTime());
        System.out.println("Время для 10.000 секунд: " + time2.getFormattedTime());
        System.out.println("Время для 100.000 секунд: " + time3.getFormattedTime());
    }
}

