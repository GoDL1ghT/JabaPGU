package ru.godl1ght.lab2.lab.task1;

import java.util.Scanner;

/**
 * Класс, представляющий дом с определенным количеством этажей.
 *
 * <p>Содержит методы для корректного отображения количества этажей с правильным окончанием.
 */
public class House {
    /**
     * Количество этажей в доме. Не может быть изменено после создания объекта.
     */
    private final int floors;

    /**
     * Создает новый дом с указанным количеством этажей.
     *
     * @param floors количество этажей в доме
     * @throws IllegalArgumentException если количество этажей меньше MIN_FLOORS
     */
    public House(int floors) {
        if (floors < 1)
            throw new IllegalArgumentException(
                    "Количество этажей не может быть меньше 1");

        this.floors = floors;
    }

    /**
     * Возвращает строковое представление количества этажей с правильным окончанием.
     *
     * @return строку с количеством этажей и правильным окончанием
     */
    private String getFloorTextForm() {
        int lastTwoDigits = floors % 100;
        int lastDigit = floors % 10;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14)
            return floors + " этажами";

        if (lastDigit == 1)
            return floors + " этажом";

        return floors + " этажами";
    }

    @Override
    public String toString() {
        return "Дом с " + getFloorTextForm();
    }

    /**
     * Точка входа в программу. Создает несколько домов и демонстрирует их работу.
     * Также позволяет пользователю ввести количество этажей для нового дома.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        House house1 = new House(1);
        House house5 = new House(5);
        House house11 = new House(11);
        House house23 = new House(23);

        System.out.println(house1);
        System.out.println(house5);
        System.out.println(house11);
        System.out.println(house23);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите количество этажей для нового дома: ");

            int userFloors = scanner.nextInt();

            House userHouse = new House(userFloors);
            System.out.println("Создан: " + userHouse);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка: введено некорректное значение");
        }
    }
}