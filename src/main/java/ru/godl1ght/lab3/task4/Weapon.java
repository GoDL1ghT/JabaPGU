package ru.godl1ght.lab3.task4;

/**
 * Абстрактный класс, представляющий базовую функциональность оружия.
 */
abstract class Weapon {
    private int ammo;

    /**
     * Конструктор с указанием начального количества патронов.
     *
     * @param ammo начальное количество патронов, должно быть неотрицательным
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
     */
    abstract void shoot();

    /**
     * Возвращает текущее количество патронов.
     *
     * @return текущее количество патронов
     */
    public int getAmmo() {
        return ammo;
    }

    /**
     * Проверяет, есть ли патроны.
     *
     * @return true, если есть хотя бы один патрон, иначе false
     */
    public boolean hasAmmo() {
        return ammo > 0;
    }

    /**
     * Уменьшает количество патронов на 1.
     */
    protected void decreaseAmmo() {
        if (ammo > 0) {
            ammo--;
        }
    }

    /**
     * Загружает новое количество патронов.
     *
     * @param ammo количество патронов для загрузки, должно быть неотрицательным
     * @return предыдущее количество патронов
     * @throws IllegalArgumentException если количество патронов отрицательное
     */
    public int load(int ammo) {
        if (ammo < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");
        }
        int oldAmmo = this.ammo;
        this.ammo = ammo;
        return oldAmmo;
    }
}