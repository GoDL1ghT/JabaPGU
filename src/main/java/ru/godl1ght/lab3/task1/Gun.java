package ru.godl1ght.lab3.task1;

public class Gun {
    private int bullets;  // Текущее количество патронов
    private final int maxBullets;  // Максимальное количество патронов

    // Конструктор с указанием начального кол-ва патронов и максимальной вместимости
    public Gun(int bullets, int maxBullets) {
        this.maxBullets = maxBullets;
        if (bullets <= maxBullets) {
            this.bullets = bullets;
        } else {
            this.bullets = maxBullets;
            System.out.println("Максимальное количество патронов превышено. Пистолет заряжен до максимума.");
        }
    }

    // Конструктор без указания начального кол-ва патронов (по умолчанию 5 патронов и максимум 5)
    public Gun() {
        this.bullets = 5;
        this.maxBullets = 5;
    }

    // Метод для стрельбы
    public void shoot() {
        if (bullets > 0) {
            System.out.print("Бах! ");
            bullets--;
        } else {
            System.out.print("Клац! ");
        }
    }

    // Метод для перезарядки пистолета
    public int reload(int additionalBullets) {
        if (additionalBullets < 0) {
            throw new IllegalArgumentException("Число патронов для перезарядки не может быть отрицательным.");
        }

        int totalBullets = bullets + additionalBullets;

        if (totalBullets > maxBullets) {
            int excessBullets = totalBullets - maxBullets;
            bullets = maxBullets;
            return excessBullets;  // Возвращаем излишек патронов
        } else {
            bullets = totalBullets;
            return 0;  // Излишков нет
        }
    }

    // Метод для разрядки пистолета
    public int unload() {
        int removedBullets = bullets;
        bullets = 0;
        return removedBullets;  // Возвращаем количество оставшихся патронов
    }

    // Метод для получения текущего количества патронов
    public int getBullets() {
        return bullets;
    }

    // Метод для получения максимальной вместимости пистолета
    public int getMaxBullets() {
        return maxBullets;
    }

    // Метод для проверки, заряжен ли пистолет
    public boolean isLoaded() {
        return bullets > 0;
    }

    public static void main(String[] args) {
        // Создаем пистолет с вместимостью 7 и заряжаем 3 патрона
        Gun gun = new Gun(3, 7);

        // Стреляем 5 раз
        for (int i = 0; i < 5; i++) {
            gun.shoot();
        }

        // Заряжаем 8 патронов, проверяем излишек
        int excess = gun.reload(8);
        if (excess > 0)
            System.out.println("Излишек патронов: " + excess);


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

