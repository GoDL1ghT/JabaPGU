package ru.godl1ght.lab3.task7;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

/**
 * Класс для вычисления степени числа.
 * Позволяет пользователю ввести число и степень, в которую его нужно возвести.
 */
public class PowerCalculator {

    /**
     * Основной метод программы.
     * Запрашивает у пользователя число и степень, вычисляет и выводит результат.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int base = getIntInput(scanner, "Введите число X: ");
        int exponent = getIntInput(scanner, "Введите степень Y: ");

        double result = calculatePower(base, exponent);
        System.out.println("Результат: " + result);

        scanner.close();
    }

    /**
     * Метод для безопасного запроса целого числа у пользователя.
     * Повторяет запрос до тех пор, пока не будет введено корректное целое число.
     *
     * @param scanner объект Scanner для чтения ввода
     * @param prompt  приглашение для ввода
     * @return введенное пользователем целое число
     */
    private static int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректное целое число.");
            }
        }
    }

    /**
     * Вычисляет результат возведения числа в степень.
     *
     * @param x основание степени
     * @param y показатель степени
     * @return результат возведения x в степень y
     */
    public static double calculatePower(int x, int y) {
        return pow(x, y);
    }

}
