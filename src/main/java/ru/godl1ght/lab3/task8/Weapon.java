package ru.godl1ght.lab3.task8;

abstract class Weapon {
    protected int ammo; // Сделали поле доступным для наследников

    public Weapon(int ammo) {
        if (ammo < 0) throw new RuntimeException();

        this.ammo = ammo;
    }

    abstract void shoot();

    public int load(int ammo) {
        if (ammo < 0) throw new RuntimeException();

        int tmp = this.ammo;
        this.ammo = ammo;
        return tmp;
    }
}

// Не смог сделать задание 3.6.2. Не нашёл Задание 1.4.1 (потому что это 2.4.1)
// а из него не нашёл задание 1.1
