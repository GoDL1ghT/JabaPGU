package ru.godl1ght.lab3.task4;

/**
 * Класс, представляющий пистолет как вид оружия.
 * Наследует функциональность базового класса Weapon.
 */
public class Gun extends Weapon {

    /**
     * Конструктор с указанием начального количества патронов.
     *
     * @param ammo начальное количество патронов, должно быть неотрицательным
     * @throws IllegalArgumentException если количество патронов отрицательное
     */
    public Gun(int ammo) {
        super(ammo);
    }

    /**
     * Конструктор без указания количества патронов (по умолчанию 5 патронов).
     */
    public Gun() {
        super(5);
    }

    /**
     * Производит выстрел из пистолета. Если есть патроны, уменьшает их количество на 1.
     */
    @Override
    public void shoot() {
        if (hasAmmo()) {
            System.out.println("Бах!");
            decreaseAmmo();
        } else {
            System.out.println("Клац!");
        }
    }

    /**
     * Точка входа для демонстрации работы пистолета.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        Gun gun = new Gun(3); // Создаем пистолет с 3 патронами

        // Стреляем 5 раз
        for (int i = 0; i < 5; i++) {
            gun.shoot();
        }
    }
}