package ru.godl1ght.lab3.task3;

import ru.godl1ght.lab3.task1.Gun;

public class AutomaticGun extends Gun {
    private final int fireRate;  // Скорострельность (выстрелов в секунду)

    // Конструктор без параметров: вместимость 30 патронов и скорострельность 30
    public AutomaticGun() {
        super(30, 30);
        this.fireRate = 30;
    }

    // Конструктор с указанием максимального числа патронов, скорострельность - половина обоймы
    public AutomaticGun(int maxBullets) {
        super(0, maxBullets);  // Начальное количество патронов 0, максимальная вместимость передается параметром
        this.fireRate = maxBullets / 2;  // Скорострельность - половина от макс. кол-ва патронов
    }

    // Конструктор с указанием максимального количества патронов в обойме и скорострельности
    public AutomaticGun(int maxBullets, int fireRate) {
        super(0, maxBullets);  // Начальное количество патронов 0, максимальная вместимость передается параметром
        if (fireRate <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительным числом.");
        }
        this.fireRate = fireRate;
    }

    // Метод для стрельбы с использованием скорострельности
    @Override
    public void shoot() {
        for (int i = 0; i < fireRate; i++) {
            super.shoot();  // Вызываем метод стрельбы из родительского класса Gun
            if (getBullets() == 0) {  // Прерываем, если закончились патроны
                break;
            }
        }
    }

    // Метод для стрельбы в течение N секунд
    public void shootForSeconds(int seconds) {
        int totalShots = fireRate * seconds;  // Общее количество выстрелов за заданное время
        for (int i = 0; i < totalShots; i++) {
            super.shoot();  // Вызываем метод стрельбы из родительского класса
            if (getBullets() == 0) {  // Прерываем, если закончились патроны
                break;
            }
        }
    }

    // Метод для получения значения скорострельности
    public int getFireRate() {
        return fireRate;
    }

    public static void main(String[] args) {
        // Создаем автомат с вместимостью 30 патронов, скорострельность 15 (половина от кол-ва патронов)
        AutomaticGun autoGun = new AutomaticGun(30);

        // Заряжаем автомат 30 патронами
        autoGun.reload(30);

        // Пробуем стрелять один раз — должно быть 15 "Бах!" (по скорострельности)
        autoGun.shoot();

        // Стреляем в течение 2 секунд — должно быть 30 "Бах!"
        System.out.println();
        autoGun.shootForSeconds(2);
    }
}

