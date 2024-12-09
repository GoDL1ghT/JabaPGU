package ru.godl1ght.lab6.task2.num3;

// Пример использования аннотации
@ToString
public class Example {
    @ToString(value = "NO")
    private String field;

    private int number;

    @Override
    public String toString() {
        return "Пример. Поле='" + field + "', Число=" + number + "}";
    }
}
