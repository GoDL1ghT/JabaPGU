package ru.godl1ght.lab3.task8;

public class Gun extends Weapon {

    // Конструктор с указанием начального количества патронов
    public Gun(int ammo) {
        super(ammo);
    }

    // Конструктор без указания количества патронов (по умолчанию 5 патронов)
    public Gun() {
        super(5);
    }

    // Упрощенный метод shoot с прямым доступом к ammo
    @Override
    public void shoot() {
        if (ammo > 0) {
            System.out.println("Бах!");
            ammo--; // Прямое уменьшение ammo
        } else System.out.println("Клац!");
    }

    public static void main(String[] args) {
        Gun gun = new Gun(3); // Создаем пистолет с 3 патронами

        // Стреляем 5 раз
        for (int i = 0; i < 5; i++) {
            gun.shoot();
        }
    }
}

