package ru.godl1ght.lab6.task3;

class HumanTests {

    // Тест на возраст человека
    public static boolean testAgeRange(Human h) {
        int age = h.getAge();
        return age >= 1 && age <= 200;
    }

    // Тест на корректность значения возраста (возраст должен быть больше нуля)
    public static boolean testValidAge(Human h) {
        return h.getAge() > 0;
    }
}
