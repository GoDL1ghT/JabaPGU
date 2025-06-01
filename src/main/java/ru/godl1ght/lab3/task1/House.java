package ru.godl1ght.lab3.task1;

import java.util.Scanner;

/**
 * Класс, представляющий дом с определенным количеством этажей.
 */
public class House {
    /**
     * Количество этажей в доме.
     */
    private final int floors;

    /**
     * Конструктор создает экземпляр дома с указанным количеством этажей.
     *
     * @param floors количество этажей в доме
     * @throws IllegalArgumentException если количество этажей меньше 1
     */
    public House(int floors) {
        if (floors < 1) {
            throw new IllegalArgumentException("Количество этажей не может быть меньше 1!");
        }

        this.floors = floors;
    }

    /**
     * Возвращает строковое представление количества этажей с правильной формой слова.
     *
     * @return строку с количеством этажей и правильной формой слова
     */
    private String getFloorTextForm() {
        int lastTwoDigits = floors % 100;
        int lastDigit = floors % 10;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return floors + " этажами";
        }
        if (lastDigit == 1) {
            return floors + " этажом";
        }
        return floors + " этажами";
    }

    @Override
    public String toString() {
        return "Дом с " + getFloorTextForm();
    }

    /**
     * Основной метод для демонстрации работы класса.
     * Осуществляет ввод данных с клавиатуры и обработку возможных ошибок.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите количество этажей:");
            int floors = scanner.nextInt();
            House house = new House(floors);
            System.out.println(house);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка: введено некорректное значение");
        }
    }
}