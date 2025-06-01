package ru.godl1ght.lab2.lab.task1;

import java.util.Scanner;

/**
 * Класс для представления и работы со временем в формате "часы:минуты:секунды".
 * Поддерживает создание объекта времени из общего количества секунд и форматированный вывод.
 */
public class Time {
    private static final int SECONDS_IN_DAY = 86400;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;

    private final int seconds;

    /**
     * Создает объект Time из общего количества секунд.
     *
     * @param seconds количество секунд. Если значение отрицательное, берется модуль числа.
     *                Если значение превышает количество секунд в сутках (86400),
     *                берется остаток от деления на 86400.
     */
    public Time(int seconds) {
        // Приведение секунд к диапазону 0-86399 (эквивалент 24 часам)
        this.seconds = Math.abs(seconds) % SECONDS_IN_DAY;
    }

    /**
     * Возвращает отформатированное строковое представление времени в формате HH:MM:SS.
     *
     * @return строка с отформатированным временем
     */
    public String getFormattedTime() {
        int hours = seconds / SECONDS_IN_HOUR;
        int minutes = (seconds % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
        int secs = seconds % SECONDS_IN_MINUTE;

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }

    /**
     * Считывает целое число секунд с клавиатуры и создает объект Time.
     *
     * @param scanner объект Scanner для ввода данных
     * @return новый объект Time
     * @throws NumberFormatException если введено не целое число
     */
    public static Time readTimeFromKeyboard(Scanner scanner) throws NumberFormatException {
        System.out.print("Введите количество секунд: ");
        String input = scanner.nextLine();

        try {
            int seconds = Integer.parseInt(input);
            return new Time(seconds);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: необходимо ввести целое число.");
            throw e;
        }
    }

    public static void main(String[] args) {
        Time time1 = new Time(10);
        Time time2 = new Time(10000);
        Time time3 = new Time(100000);

        System.out.println("Время для 10 секунд: " + time1.getFormattedTime());
        System.out.println("Время для 10.000 секунд: " + time2.getFormattedTime());
        System.out.println("Время для 100.000 секунд: " + time3.getFormattedTime());

        try (Scanner scanner = new Scanner(System.in)) {
            Time userTime = readTimeFromKeyboard(scanner);
            System.out.println("Введенное время: " + userTime.getFormattedTime());
        } catch (NumberFormatException e) {
            System.err.println("Программа завершена из-за ошибки ввода.");
        }

    }

}
