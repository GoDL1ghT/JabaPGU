package ru.godl1ght.lab4.task1.num6;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableValueList<T> {
    private final List<T> values;

    // Конструктор с varargs (поддерживает массивы)
    @SafeVarargs
    public ImmutableValueList(T... values) {
        this.values = List.copyOf(List.of(values));
    }

    // Конструктор с другим списком
    public ImmutableValueList(List<T> otherList) {
        this.values = List.copyOf(otherList);
    }

    // Метод получения значения по позиции
    public T getValueAt(int position) {
        if (position < 0 || position >= values.size()) {
            throw new IndexOutOfBoundsException("Неверная позиция: " + position);
        }
        return values.get(position);
    }

    // Метод замены значения по позиции, возвращает новый объект
    public ImmutableValueList<T> replaceValueAt(int position, T newValue) {
        if (position < 0 || position >= values.size()) {
            throw new IndexOutOfBoundsException("Неверная позиция: " + position);
        }
        List<T> newValues = new ArrayList<>(values);
        newValues.set(position, newValue);
        return new ImmutableValueList<>(newValues);
    }

    // Преобразование в строку
    @Override
    public String toString() {
        return values.toString();
    }

    // Проверка на пустоту списка
    public boolean isEmpty() {
        return values.isEmpty();
    }

    // Получение текущего размера списка
    public int size() {
        return values.size();
    }

    // Получение всех значений в виде неизменяемого списка
    public List<T> getAll() {
        return values;
    }

    // Пример использования
    public static void main(String[] args) {
        // Инициализация разными способами
        ImmutableValueList<Integer> intList = new ImmutableValueList<>(1, 2, 3);
        ImmutableValueList<String> stringList = new ImmutableValueList<>(List.of("A", "B", "C"));

        // Примеры использования методов
        System.out.println("Список чисел: " + intList); // Выводит: [1, 2, 3]
        System.out.println("Список строк: " + stringList); // Выводит: [A, B, C]

        System.out.println("Элемент на позиции 1 (числа): " + intList.getValueAt(1)); // Выводит: 2
        System.out.println("Элемент на позиции 1 (строки): " + stringList.getValueAt(1)); // Выводит: B

        System.out.println("Список чисел пустой: " + intList.isEmpty()); // Выводит: false
        System.out.println("Размер списка строк: " + stringList.size()); // Выводит: 3

        // Замена значения
        ImmutableValueList<Integer> newIntList = intList.replaceValueAt(1, 42);
        System.out.println("Новый список после замены: " + newIntList); // Выводит: [1, 42, 3]

        // Получение всех значений
        List<String> allStringValues = stringList.getAll();
        System.out.println("Все значения строкового списка: " + allStringValues); // Выводит: [A, B, C]
    }
}
