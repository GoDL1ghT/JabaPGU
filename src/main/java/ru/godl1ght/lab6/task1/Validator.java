package ru.godl1ght.lab6.task1;

import java.lang.reflect.Method;

public class Validator {

    // Метод для валидации тестируемого объекта
    public static void validate(Object testObject, Class<?> testClass) throws Exception {
        // Получаем все методы из класса тестов (в нашем случае класса, проверяющего объект)
        Method[] methods = testClass.getDeclaredMethods();

        // Проходим по всем методам тестирования
        for (Method method : methods) {
            // Проверяем, что метод возвращает boolean
            if (method.getReturnType().equals(boolean.class)) {
                method.setAccessible(true); // Делаем метод доступным для вызова, даже если он private
                // Вызываем метод теста, передавая тестируемый объект (в нашем случае объект Human)
                Object result = method.invoke(null, testObject); // Мы предполагаем, что методы тестов статические
                if (result instanceof Boolean && !((Boolean) result)) {
                    // Если тест не пройден (метод возвращает false), выбрасываем исключение с подробным сообщением
                    throw new ValidationException("ошибка в " + method.getName() + ": " + getErrorMessage(method, testObject));
                }
            }
        }
    }

    // Метод для генерации подробных сообщений об ошибке для каждого метода теста
    private static String getErrorMessage(Method method, Object testObject) {
        if (testObject instanceof Human) {
            Human h = (Human) testObject;
            // Для метода теста testAgeRange генерируем соответствующее сообщение
            if (method.getName().equals("testAgeRange")) {
                return "возраст человека не в диапазоне от 1 до 200";
            }
            // Для метода testValidAge генерируем другое сообщение
            if (method.getName().equals("testValidAge")) {
                return "возраст человека должен быть больше нуля";
            }
        }
        return "неизвестная ошибка"; // На случай, если тест не соответствует известным шаблонам
    }

    // Исключение для ошибки валидации
    public static class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message); // Передаем сообщение в конструктор исключения
        }
    }
}
