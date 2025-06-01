package ru.godl1ght.lab3.task8;

/**
 * Абстрактный класс, представляющий оружие.
 * Содержит базовую функциональность для работы с боеприпасами.
 */
abstract class Weapon {
    protected int ammo;

    /**
     * Создает экземпляр оружия с указанным количеством патронов.
     *
     * @param ammo количество патронов, должно быть неотрицательным
     * @throws IllegalArgumentException если количество патронов отрицательное
     */
    public Weapon(int ammo) {
        if (ammo < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");
        }
        this.ammo = ammo;
    }

    /**
     * Абстрактный метод для произведения выстрела.
     * Должен быть реализован в подклассах.
     */
    abstract void shoot();

    /**
     * Загружает новое количество патронов в оружие.
     *
     * @param ammo новое количество патронов, должно быть неотрицательным
     * @return предыдущее количество патронов
     * @throws IllegalArgumentException если количество патронов отрицательное
     */
    public int load(int ammo) {
        if (ammo < 0)
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");

        int tmp = this.ammo;
        this.ammo = ammo;
        return tmp;
    }
}