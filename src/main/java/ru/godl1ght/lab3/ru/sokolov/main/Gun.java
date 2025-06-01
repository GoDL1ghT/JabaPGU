package ru.godl1ght.lab3.ru.sokolov.main;

/**
 * Класс, представляющий пистолет с определенным количеством патронов.
 * Поддерживает операции стрельбы и проверки количества оставшихся патронов.
 */
public class Gun {
    private int bullets;

    /**
     * Конструктор с указанием начального количества патронов.
     *
     * @param bullets начальное количество патронов. Должно быть неотрицательным.
     * @throws IllegalArgumentException если количество патронов отрицательное
     */
    public Gun(int bullets) {
        if (bullets < 0)
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");

        this.bullets = bullets;
    }

    /**
     * Конструктор без указания начального количества патронов (по умолчанию 5 патронов).
     */
    public Gun() {
        this.bullets = 5;
    }

    /**
     * Метод для совершения выстрела. Уменьшает количество патронов на 1, если они есть.
     * Выводит "Бах!" при успешном выстреле и "Клац!" при отсутствии патронов.
     */
    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        } else
            System.out.println("Клац!");
    }

    /**
     * Возвращает текущее количество патронов в пистолете.
     *
     * @return количество оставшихся патронов
     */
    public int getBullets() {
        return bullets;
    }

    /**
     * Демонстрация работы класса Gun с возможностью ввода данных с клавиатуры.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {

        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("Введите начальное количество патронов для первого пистолета: ");
            int initialBullets = scanner.nextInt();
            Gun gunWithCustomBullets = new Gun(initialBullets);

            Gun gunWithDefaultBullets = new Gun();

            System.out.println("\nПистолет с " + initialBullets + " патронами:");
            for (int i = 0; i < 5; i++) {
                gunWithCustomBullets.shoot();
            }
            System.out.println("Оставшиеся патроны: " + gunWithCustomBullets.getBullets());

            System.out.println("\nПистолет с патронами по умолчанию:");
            for (int i = 0; i < 5; i++) {
                gunWithDefaultBullets.shoot();
            }
            System.out.println("Оставшиеся патроны: " + gunWithDefaultBullets.getBullets());
        } catch (java.util.InputMismatchException e) {
            System.err.println("Ошибка: введено нечисловое значение");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
