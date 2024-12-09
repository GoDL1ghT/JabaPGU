package ru.godl1ght.lab6.task3;

import java.lang.reflect.Method;

public class Validator {

    // Метод для валидации произвольного набора объектов
    public static void validate(Object... objects) throws Exception {
        // Проходим по каждому объекту в переданном наборе
        for (Object obj : objects) {
            // Получаем класс объекта
            Class<?> objClass = obj.getClass();

            // Ищем аннотацию @Validate у класса объекта и его суперклассов
            while (objClass != null) {
                if (objClass.isAnnotationPresent(Validate.class)) {
                    // Получаем классы тестов, указанные в аннотации @Validate
                    Validate validateAnnotation = objClass.getAnnotation(Validate.class);
                    Class<?>[] testClasses = validateAnnotation.value();

                    // Проходим по всем классам тестов
                    for (Class<?> testClass : testClasses) {
                        // Получаем все методы из класса тестов
                        Method[] methods = testClass.getDeclaredMethods();

                        // Для каждого метода в тестах
                        for (Method method : methods) {
                            // Проверяем, что метод возвращает boolean
                            if (method.getReturnType().equals(boolean.class)) {
                                method.setAccessible(true);
                                // Вызываем метод теста, передавая объект
                                Object result = method.invoke(null, obj);
                                if (result instanceof Boolean && !((Boolean) result)) {
                                    // Если тест не пройден (возвращает false), выбрасываем исключение
                                    throw new ValidationException("Ошибка в " + method.getName() + ": " + getErrorMessage(method, obj));
                                }
                            }
                        }
                    }
                    break; // Если нашли аннотацию, прекращаем поиск в суперклассах
                }
                objClass = objClass.getSuperclass(); // Переходим к суперклассу
            }
        }
    }

    // Метод для генерации сообщений об ошибке
    private static String getErrorMessage(Method method, Object testObject) {
        if (testObject instanceof Human) {
            Human h = (Human) testObject;
            if (method.getName().equals("testAgeRange")) {
                return "возраст человека не в диапазоне от 1 до 200";
            }
            if (method.getName().equals("testValidAge")) {
                return "возраст человека должен быть больше нуля";
            }
        }
        return "неизвестная ошибка";
    }
}

