package ru.godl1ght.lab3.task5;

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

    // Метод для получения текущего количества патронов (опционально)
    public int getBullets() {
        return bullets;
    }
}

class Shooter {
    private String name;
    private Gun weapon;

    // Конструктор, принимающий имя стрелка и устанавливающий его без оружия
    public Shooter(String name) {
        this.name = name;
        this.weapon = null;
    }

    // Геттер и сеттер для имени стрелка
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Геттер и сеттер для оружия стрелка
    public Gun getWeapon() {
        return weapon;
    }

    public void setWeapon(Gun weapon) {
        this.weapon = weapon;
    }

    // Метод для стрельбы
    public void shoot() {
        if (weapon != null) {
            System.out.print(name + " стреляет: ");
            weapon.shoot();
        } else System.out.println(name + ": не могу участвовать в перестрелке");
    }

    public static void main(String[] args) {
        // Создаем трех стрелков с разными характеристиками
        Shooter shooterWithoutGun = new Shooter("Безоружный");
        Shooter shooterWithPistol = new Shooter("Пистолетчик");
        Shooter shooterWithRifle = new Shooter("Автоматчик");

        // Назначаем оружие некоторым стрелкам
        shooterWithPistol.setWeapon(new Gun(3)); // Пистолет с 3 патронами
        shooterWithRifle.setWeapon(new Gun(5)); // Автомат с 5 патронами

        // Каждый стрелок делает попытку выстрела
        shooterWithoutGun.shoot(); // Ожидается: не могу участвовать в перестрелке
        shooterWithPistol.shoot(); // Ожидается: Бах!
        shooterWithRifle.shoot();  // Ожидается: Бах!
    }
}
