package ru.godl1ght.lab3.task7;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import java.util.Scanner;

public class PowerCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод числа X с проверкой
        int base = getIntInput(scanner, "Введите число X: ");

        // Запрашиваем у пользователя ввод степени Y с проверкой
        int exponent = getIntInput(scanner, "Введите степень Y: ");

        // Вычисляем результат и выводим его
        double result = calculatePower(base, exponent);
        System.out.println("Результат: " + result);

        scanner.close();
    }

    // Метод для безопасного запроса целого числа
    private static int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return parseInt(input); // Пытаемся преобразовать ввод в целое число
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректное целое число.");
            }
        }
    }

    // Метод для возведения числа в степень
    public static double calculatePower(int x, int y) {
        return pow(x, y);
    }
}

