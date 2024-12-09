package ru.godl1ght.lab6.task3;

public class Main {
    public static void main(String[] args) {
        try {
            // Создаем несколько объектов
            Human human1 = new Human(750);
            Human human2 = new Human(25);

            Person person1 = new Person(150);
            Person person2 = new Person(0);

            // Выполняем валидацию объектов
            Validator.validate(human1, human2, person1, person2);
        } catch (ValidationException e) {
            // Печать сообщения об ошибке
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
