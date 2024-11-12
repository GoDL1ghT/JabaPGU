package ru.godl1ght.lab3.task2;

import java.util.Arrays;
import java.util.List;

public final class ImmutableValueList {
    private final int[] values;

    // Конструктор с varargs (также поддерживает массив)
    public ImmutableValueList(int... values) {
        this.values = values.clone();
    }

    // Конструктор с другим списком
    public ImmutableValueList(List<Integer> otherList) {
        this.values = otherList.stream().mapToInt(Integer::intValue).toArray();
    }

    // Метод получения значения по позиции
    public int getValueAt(int position) {
        if (position < 0 || position >= values.length) {
            throw new IndexOutOfBoundsException("Неверная позиция: " + position);
        }
        return values[position];
    }

    // Метод замены значения по позиции, возвращает новый объект
    public ImmutableValueList replaceValueAt(int position, int newValue) {
        if (position < 0 || position >= values.length) {
            throw new IndexOutOfBoundsException("Неверная позиция: " + position);
        }
        int[] newValues = values.clone();
        newValues[position] = newValue;
        return new ImmutableValueList(newValues);
    }

    // Преобразование в строку
    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    // Проверка на пустоту списка
    public boolean isEmpty() {
        return values.length == 0;
    }

    // Получение текущего размера списка
    public int size() {
        return values.length;
    }

    // Получение всех значений в виде массива
    public int[] getAll() {
        return values.clone(); // Клонирование для защиты неизменяемости
    }

    // Пример использования
    public static void main(String[] args) {
        // Инициализация разными способами
        ImmutableValueList list1 = new ImmutableValueList(1, 2, 3); // через varargs
        ImmutableValueList list2 = new ImmutableValueList(new int[]{4, 5, 6}); // через массив
        ImmutableValueList list3 = new ImmutableValueList(Arrays.asList(7, 8, 9)); // через список

        // Примеры использования методов
        System.out.println("Список 1: " + list1);  // Выводит: [1, 2, 3]
        System.out.println("Элемент на позиции 1: " + list1.getValueAt(1)); // Выводит: 2
        System.out.println("Список 1 пустой: " + list1.isEmpty()); // Выводит: false
        System.out.println("Размер списка 1: " + list1.size()); // Выводит: 3

        // Замена значения
        ImmutableValueList newList = list1.replaceValueAt(1, 42);
        System.out.println("Новый список после замены: " + newList); // Выводит: [1, 42, 3]

        // Получение всех значений в виде массива
        int[] allValuesArray = list1.getAll();
        System.out.println("Массив со всеми значениями списка 1: " + Arrays.toString(allValuesArray)); // Выводит: 1, 2, 3
    }
}
