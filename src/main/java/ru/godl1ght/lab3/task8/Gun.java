package ru.godl1ght.lab3.task8;

import java.util.Scanner;

/**
 * Класс, представляющий пистолет как вид оружия.
 * Наследуется от абстрактного класса Weapon.
 */
public class Gun extends Weapon {

    /**
     * Конструктор с указанием начального количества патронов.
     *
     * @param ammo количество патронов, должно быть неотрицательным
     * @throws IllegalArgumentException если количество патронов отрицательное
     */
    public Gun(int ammo) {
        super(ammo);
    }

    /**
     * Конструктор без указания количества патронов (по умолчанию 5 патронов).
     */
    public Gun() {
        super(5);
    }

    /**
     * Производит выстрел из пистолета. Уменьшает количество патронов на 1 при каждом выстреле.
     * Если патронов нет, имитирует осечку.
     */
    @Override
    public void shoot() {
        if (ammo > 0) {
            System.out.println("Бах!");
            ammo--;
        } else {
            System.out.println("Клац!");
        }
    }

    /**
     * Демонстрирует работу класса Gun.
     * Позволяет пользователю ввести количество патронов и производит серию выстрелов.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите количество патронов: ");
            int ammo = scanner.nextInt();
            if (ammo < 0) {
                System.out.println("Количество патронов не может быть отрицательным. Установлено значение по умолчанию (5).");
                ammo = 5;
            }

            Gun gun = new Gun(ammo);
            System.out.println("Стреляем 5 раз:");

            for (int i = 0; i < 5; i++) {
                gun.shoot();
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Установлено значение по умолчанию (5).");
            Gun gun = new Gun(5);
            for (int i = 0; i < 5; i++) {
                gun.shoot();
            }
        }
    }
}