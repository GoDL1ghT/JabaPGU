package ru.godl1ght.lab3.task5;

/**
 * Класс, представляющий огнестрельное оружие с ограниченным количеством патронов.
 */
public class Gun {
    private int bullets;

    /**
     * Конструктор с указанием начального количества патронов.
     *
     * @param bullets начальное количество патронов, должно быть неотрицательным
     * @throws IllegalArgumentException если количество патронов отрицательное
     */
    public Gun(int bullets) {
        if (bullets < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным");
        }
        this.bullets = bullets;
    }

    /**
     * Конструктор без указания начального количества патронов (по умолчанию 5 патронов).
     */
    public Gun() {
        this.bullets = 5;
    }

    /**
     * Метод для совершения выстрела.
     * При наличии патронов уменьшает их количество на 1.
     */
    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        } else {
            System.out.println("Клац!");
        }
    }

    /**
     * Возвращает текущее количество патронов.
     *
     * @return количество оставшихся патронов
     */
    public int getBullets() {
        return bullets;
    }
}