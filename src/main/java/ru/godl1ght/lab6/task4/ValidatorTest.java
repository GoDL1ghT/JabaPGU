package ru.godl1ght.lab6.task4;

import org.junit.jupiter.api.Test;
import ru.godl1ght.lab6.task3.Human;
import ru.godl1ght.lab6.task3.Person;
import ru.godl1ght.lab6.task3.ValidationException;
import ru.godl1ght.lab6.task3.Validator;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    // Тест на проверку выхода за диапазон (возраст = 750)
    @Test
    void testInvalidAgeRange() {
        Human human = new Human(750); // Некорректный возраст (слишком большой)

        // Ожидаем что метод валидации выбросит ValidationException
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            Validator.validate(human);
        });

        // проверяем что ошибка связана с методом testAgeRange
        assertTrue(exception.getMessage().contains("Ошибка в testAgeRange"));
        assertTrue(exception.getMessage().contains("возраст человека не в диапазоне от 1 до 200"));
    }

    // Тест на проверку возраста человека = 0
    @Test
    void testInvalidAgeZero() {
        Human human = new Human(0);

        // ожидаем что метод валидации выбросит ValidationException
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            Validator.validate(human);
        });

        // Проверяем что ошибка связана с методом testValidAge
        assertTrue(exception.getMessage().contains("Ошибка в testValidAge"));
        assertTrue(exception.getMessage().contains("возраст человека должен быть больше нуля"));
    }

    // Тест на проверку корректного возраста человека
    @Test
    void testValidAge() {
        Human human = new Human(25);

        // Ожидаем что метод валидации не выбросит исключение
        assertDoesNotThrow(() -> {
            Validator.validate(human);
        });
    }

    // Тест на проверку корректного возраста для объекта Person
    @Test
    void testValidPersonAge() {
        Person person = new Person(150);

        // Ожидаем что метод валидации не выбросит исключение
        assertDoesNotThrow(() -> {
            Validator.validate(person);
        });
    }

    // Тест на проверку некорректного возраста для объекта Person (возраст 0)
    @Test
    void testInvalidPersonAgeZero() {
        Person person = new Person(0);

        // ожидаем что метод валидации выбросит ValidationException
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            Validator.validate(person);
        });

        // проверяем что ошибка связана с методом testValidAge
        assertTrue(exception.getMessage().contains("Ошибка в testValidAge"));
        assertTrue(exception.getMessage().contains("возраст человека должен быть больше нуля"));
    }

    // Тест на проверку корректного возраста для объекта Person (возраст 200)
    @Test
    void testValidPersonAgeRange() {
        Person person = new Person(200);

        // Ожидаем что метод валидации не выбросит исключение
        assertDoesNotThrow(() -> {
            Validator.validate(person);
        });
    }
}

