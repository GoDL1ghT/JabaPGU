package ru.godl1ght.lab2.lab.task5;

/**
 * Класс, представляющий модель пистолета с ограниченным количеством патронов.
 */
public class Gun {
    private static final int DEFAULT_BULLETS = 5;
    private int bullets;

    /**
     * Конструктор с указанием начального количества патронов.
     *
     * @param bullets начальное количество патронов, должно быть неотрицательным
     * @throws IllegalArgumentException если количество патронов отрицательное
     */
    public Gun(int bullets) {
        if (bullets < 0) {
            throw new IllegalArgumentException(
                    "Количество патронов не может быть отрицательным: " + bullets);
        }
        this.bullets = bullets;
    }

    /**
     * Конструктор без параметров, инициализирует пистолет значением по умолчанию (5 патронов).
     */
    public Gun() {
        this.bullets = DEFAULT_BULLETS;
    }

    /**
     * Производит выстрел из пистолета. Уменьшает количество патронов на 1 при успешном выстреле.
     * Выводит "Бах!" при наличии патронов и "Клац!" при их отсутствии.
     */
    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        } else
            System.out.println("Клац!");
    }

    /**
     * Возвращает текущее количество патронов в пистолете.
     *
     * @return количество оставшихся патронов
     */
    public int getBullets() {
        return bullets;
    }

    /**
     * Демонстрирует работу класса Gun.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        Gun gun = new Gun(3);

        // Стреляем 5 раз
        for (int i = 0; i < 5; i++) {
            gun.shoot();
        }

    }

}
