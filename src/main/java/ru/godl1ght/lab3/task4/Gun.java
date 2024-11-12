package ru.godl1ght.lab3.task4;

public class Gun extends Weapon {

    // Конструктор с указанием начального количества патронов
    public Gun(int ammo) {
        super(ammo); // Передаем количество патронов в конструктор родителя
    }

    // Конструктор без указания количества патронов (по умолчанию 5 патронов)
    public Gun() {
        super(5); // Устанавливаем значение по умолчанию, вызывая конструктор Weapon
    }

    // Переопределяем метод shoot
    @Override
    public void shoot() {
        if (getAmmo()) System.out.println("Бах!");
        else System.out.println("Клац!");
    }

    public static void main(String[] args) {
        Gun gun = new Gun(3); // Создаем пистолет с 3 патронами

        // Стреляем 5 раз
        for (int i = 0; i < 5; i++) {
            gun.shoot();
        }
    }
}

