package ru.godl1ght.lab2.lab.task5;

public class Gun {
    private int bullets;

    // Конструктор с указанием начального кол-ва патронов
    public Gun(int bullets) {
        this.bullets = bullets;
    }

    // Конструктор без указания начального кол-ва патронов (по умолчанию 5 патронов)
    public Gun() {
        this.bullets = 5;
    }

    // Метод для стрельбы
    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        } else
            System.out.println("Клац!");
    }

    // Метод для получения текущего количества патронов (по желанию)
    public int getBullets() {
        return bullets;
    }

    public static void main(String[] args) {
        Gun gun = new Gun(3); // Создаем пистолет с 3 патронами

        // Стреляем 5 раз
        for (int i = 0; i < 5; i++) {
            gun.shoot();
        }
    }
}
