package ru.godl1ght.lab6.task1;

public class Main {
    public static void main(String[] args) {
        try {
            // Создаем объект Human с некорректным возрастом (750 лет)
            Human h = new Human(750);
            System.out.println(h); // Выводим объект, например: Human{age=750}

            // Выполняем валидацию объекта с использованием класса тестов HumanTests
            Validator.validate(h, HumanTests.class);
        } catch (Validator.ValidationException e) {
            // Печатаем сообщение об ошибке, если валидация не прошла
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
