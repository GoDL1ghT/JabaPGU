package ru.godl1ght.lab3.task1;

/**
 * Класс, представляющий пистолет с возможностью стрельбы, перезарядки и разрядки.
 * Поддерживает ограничение на максимальное количество патронов.
 */
public class Gun {
    private int bullets; // Текущее количество патронов
    private final int maxBullets; // Максимальное количество патронов

    /**
     * Конструктор с указанием начального количества патронов и максимальной вместимости.
     *
     * @param bullets    начальное количество патронов
     * @param maxBullets максимальная вместимость пистолета
     * @throws IllegalArgumentException если bullets или maxBullets отрицательные, или maxBullets равен нулю
     */
    public Gun(int bullets, int maxBullets) {
        if (bullets < 0) {
            throw new IllegalArgumentException("Начальное количество патронов не может быть отрицательным.");
        }
        if (maxBullets <= 0) {
            throw new IllegalArgumentException("Максимальная вместимость должна быть положительной.");
        }

        this.maxBullets = maxBullets;
        if (bullets <= maxBullets) {
            this.bullets = bullets;
        } else {
            this.bullets = maxBullets;
            System.out.println(
                    "Максимальное количество патронов превышено. Пистолет заряжен до максимума.");
        }
    }

    /**
     * Конструктор без указания параметров (по умолчанию 5 патронов и максимум 5).
     */
    public Gun() {
        this.bullets = 5;
        this.maxBullets = 5;
    }

    /**
     * Производит выстрел из пистолета. Если патроны есть - уменьшает их количество на 1.
     */
    public void shoot() {
        if (bullets > 0) {
            System.out.print("Бах! ");
            bullets--;
        } else {
            System.out.print("Клац! ");
        }
    }

    /**
     * Перезаряжает пистолет указанным количеством патронов.
     *
     * @param additionalBullets количество добавляемых патронов
     * @return количество патронов, которые не поместились в пистолет
     * @throws IllegalArgumentException если additionalBullets отрицательное
     */
    public int reload(int additionalBullets) {
        if (additionalBullets < 0) {
            throw new IllegalArgumentException("Число патронов для перезарядки не может быть отрицательным.");
        }

        int totalBullets = bullets + additionalBullets;

        if (totalBullets > maxBullets) {
            int excessBullets = totalBullets - maxBullets;
            bullets = maxBullets;
            return excessBullets;
        } else {
            bullets = totalBullets;
            return 0;
        }
    }

    /**
     * Полностью разряжает пистолет.
     *
     * @return количество извлеченных патронов
     */
    public int unload() {
        int removedBullets = bullets;
        bullets = 0;
        return removedBullets;
    }

    /**
     * Возвращает текущее количество патронов в пистолете.
     *
     * @return текущее количество патронов
     */
    public int getBullets() {
        return bullets;
    }

    /**
     * Возвращает максимальную вместимость пистолета.
     *
     * @return максимальное количество патронов
     */
    public int getMaxBullets() {
        return maxBullets;
    }

    /**
     * Проверяет, заряжен ли пистолет.
     *
     * @return true, если в пистолете есть патроны, иначе false
     */
    public boolean isLoaded() {
        return bullets > 0;
    }

    /**
     * Демонстрация работы класса Gun.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Создаем пистолет с вместимостью 7 и заряжаем 3 патрона
        Gun gun = new Gun(3, 7);

        // Стреляем 5 раз
        for (int i = 0; i < 5; i++) {
            gun.shoot();
        }

        // Заряжаем 8 патронов, проверяем излишек
        int excess = gun.reload(8);
        if (excess > 0) {
            System.out.println("Излишек патронов: " + excess);
        }

        // Стреляем еще 2 раза
        for (int i = 0; i < 2; i++) {
            gun.shoot();
        }

        // Разряжаем пистолет
        int returnedBullets = gun.unload();
        System.out.println("Пистолет разряжен, возвращено патронов: " + returnedBullets);

        // Контрольный выстрел
        gun.shoot();
    }

}
