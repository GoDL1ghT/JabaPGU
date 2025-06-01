package ru.godl1ght.lab3.task5;

/**
 * Класс, представляющий стрелка, который может быть вооружен.
 */
public class Shooter {
    private String name;
    private Gun weapon;

    /**
     * Конструктор, создающий стрелка с указанным именем без оружия.
     *
     * @param name имя стрелка, не должно быть null или пустым
     * @throws IllegalArgumentException если имя null или пустое
     */
    public Shooter(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя стрелка не может быть null или пустым");
        }
        this.name = name;
        this.weapon = null;
    }

    /**
     * Возвращает имя стрелка.
     *
     * @return имя стрелка
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает новое имя стрелка.
     *
     * @param name новое имя стрелка, не должно быть null или пустым
     * @throws IllegalArgumentException если имя null или пустое
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя стрелка не может быть null или пустым");
        }
        this.name = name;
    }

    /**
     * Возвращает оружие стрелка.
     *
     * @return оружие стрелка (может быть null)
     */
    public Gun getWeapon() {
        return weapon;
    }

    /**
     * Устанавливает оружие для стрелка.
     *
     * @param weapon оружие для установки (может быть null)
     */
    public void setWeapon(Gun weapon) {
        this.weapon = weapon;
    }

    /**
     * Совершает выстрел из оружия стрелка, если оно есть.
     */
    public void shoot() {
        if (weapon != null) {
            System.out.print(name + " стреляет: ");
            weapon.shoot();
        } else {
            System.out.println(name + ": не могу участвовать в перестрелке");
        }
    }

    /**
     * Демонстрационный метод для тестирования функциональности классов Gun и Shooter.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        Shooter shooterWithoutGun = new Shooter("Безоружный");
        Shooter shooterWithPistol = new Shooter("Пистолетчик");
        Shooter shooterWithRifle = new Shooter("Автоматчик");

        shooterWithPistol.setWeapon(new Gun(3)); // Пистолет с 3 патронами
        shooterWithRifle.setWeapon(new Gun(5)); // Автомат с 5 патронами

        shooterWithoutGun.shoot(); // Ожидается: не могу участвовать в перестрелке
        shooterWithPistol.shoot(); // Ожидается: Бах!
        shooterWithRifle.shoot();  // Ожидается: Бах!
    }
}