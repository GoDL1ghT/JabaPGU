package ru.godl1ght.lab3.ru.sokolov.main;

public class Gun {
    private int bullets;

    // Конструктор с указанием начального количества патронов
    public Gun(int bullets) {
        this.bullets = bullets;
    }

    // Конструктор без указания начального количества патронов (по умолчанию 5 патронов)
    public Gun() {
        this.bullets = 5;
    }

    // Метод для стрельбы
    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        } else {
            System.out.println("Клац!");
        }
    }

    // Метод для получения текущего количества патронов
    public int getBullets() {
        return bullets;
    }

    public static void main(String[] args) {
        // Демонстрация работы
        Gun gunWith3Bullets = new Gun(3); // Создаем пистолет с 3 патронами
        Gun gunWithDefaultBullets = new Gun(); // Создаем пистолет с патронами по умолчанию (5)

        System.out.println("Пистолет с 3 патронами:");
        // Стреляем 5 раз из пистолета с 3 патронами
        for (int i = 0; i < 5; i++) {
            gunWith3Bullets.shoot();
        }
        System.out.println("Оставшиеся патроны: " + gunWith3Bullets.getBullets());

        System.out.println("\nПистолет с патронами по умолчанию:");
        // Стреляем 5 раз из пистолета с патронами по умолчанию
        for (int i = 0; i < 5; i++) {
            gunWithDefaultBullets.shoot();
        }
        System.out.println("Оставшиеся патроны: " + gunWithDefaultBullets.getBullets());
    }
}

