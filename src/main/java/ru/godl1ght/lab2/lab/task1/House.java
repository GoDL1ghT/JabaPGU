package ru.godl1ght.lab2.lab.task1;

// Объединение задач 1.5 и 4.3
public class House {
    // Поле с этажами помечено final, чтобы его нельзя было изменить
    private final int floors;

    // Конструктор класса Дом
    public House(int floors) {
        this.floors = floors;
    }

    // Метод для получения правильного окончания слова "этаж"
    private String getFloorTextForm() {
        int lastDigit = floors % 10;

        if (lastDigit == 1) return floors + " этажом";
        else return floors + " этажами";
    }

    @Override
    public String toString() {
        return "Дом с " + getFloorTextForm();
    }

    public static void main(String[] args) {
        House house1 = new House(1);
        House house5 = new House(5);
        House house23 = new House(23);

        System.out.println(house1);
        System.out.println(house5);
        System.out.println(house23);

//         Демонстрация невозможности изменить количество этажей
//         house1.floors = 10;
//         Это приведет к ошибке компиляции, т.к. поле floors final
    }
}
