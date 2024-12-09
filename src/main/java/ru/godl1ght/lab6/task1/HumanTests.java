package ru.godl1ght.lab6.task1;

class HumanTests {

    // Тест на возраст человека
    public static boolean testAgeRange(Human h) {
        int age = h.getAge();
        return age >= 1 && age <= 200; // возраст должен быть в пределах от 1 до 200
    }

    // Можно добавить другие тесты
    // Например, тест на некорректное значение возраста (например, отрицательный возраст)
    public static boolean testValidAge(Human h) {
        return h.getAge() > 0;  // возраст должен быть больше нуля
    }
}
