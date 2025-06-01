package ru.godl1ght.lab3.task3;

import ru.godl1ght.lab3.task1.Gun;

/**
 * Класс, представляющий автоматическое оружие с определенной скорострельностью.
 * Наследуется от базового класса Gun.
 */
public class AutomaticGun extends Gun {
    /**
     * Скорострельность (выстрелов в секунду).
     */
    private final int fireRate;

    /**
     * Конструктор без параметров: вместимость 30 патронов и скорострельность 30.
     */
    public AutomaticGun() {
        super(30, 30);
        this.fireRate = 30;
    }

    /**
     * Конструктор с указанием максимального числа патронов.
     * Скорострельность устанавливается как половина обоймы.
     *
     * @param maxBullets максимальное количество патронов
     * @throws IllegalArgumentException если maxBullets не положительное число
     */
    public AutomaticGun(int maxBullets) {
        super(0, maxBullets);
        if (maxBullets <= 0) {
            throw new IllegalArgumentException(
                    "Максимальное количество патронов должно быть положительным числом.");
        }
        this.fireRate = maxBullets / 2;
    }

    /**
     * Конструктор с указанием максимального количества патронов и скорострельности.
     *
     * @param maxBullets максимальное количество патронов
     * @param fireRate   скорострельность (выстрелов в секунду)
     * @throws IllegalArgumentException если fireRate или maxBullets не положительные числа
     */
    public AutomaticGun(int maxBullets, int fireRate) {
        super(0, maxBullets);
        if (maxBullets <= 0) {
            throw new IllegalArgumentException(
                    "Максимальное количество патронов должно быть положительным числом.");
        }
        if (fireRate <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительным числом.");
        }
        this.fireRate = fireRate;
    }

    /**
     * Производит выстрел с использованием скорострельности.
     * Вызывает родительский метод shoot() fireRate раз или пока не закончатся патроны.
     */
    @Override
    public void shoot() {
        if (getBullets() == 0) {
            return;
        }
        for (int i = 0; i < fireRate; i++) {
            super.shoot();
            if (getBullets() == 0) {
                break;
            }
        }
    }

    /**
     * Производит стрельбу в течение указанного количества секунд.
     *
     * @param seconds количество секунд стрельбы
     * @throws IllegalArgumentException если seconds не положительное число
     */
    public void shootForSeconds(int seconds) {
        if (seconds <= 0) {
            throw new IllegalArgumentException("Количество секунд должно быть положительным числом.");
        }
        if (getBullets() == 0) {
            return;
        }
        int totalShots = fireRate * seconds;
        for (int i = 0; i < totalShots; i++) {
            super.shoot();
            if (getBullets() == 0) {
                break;
            }
        }
    }

    /**
     * Возвращает значение скорострельности.
     *
     * @return скорострельность (выстрелов в секунду)
     */
    public int getFireRate() {
        return fireRate;
    }

    /**
     * Демонстрация работы класса AutomaticGun.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        AutomaticGun autoGun = new AutomaticGun(30);
        autoGun.reload(30);
        autoGun.shoot();
        System.out.println();
        autoGun.shootForSeconds(2);
    }
}