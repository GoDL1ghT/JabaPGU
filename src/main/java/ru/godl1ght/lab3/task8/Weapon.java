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

