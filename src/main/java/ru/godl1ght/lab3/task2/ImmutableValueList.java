package ru.godl1ght.lab3.task2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Неизменяемый список целочисленных значений.
 * Предоставляет методы для безопасного доступа и модификации с созданием новых объектов.
 */
public final class ImmutableValueList {
    private final int[] values;

    /**
     * Создает новый неизменяемый список из переданных значений.
     *
     * @param values массив или последовательность целых чисел
     */
    public ImmutableValueList(int... values) {
        this.values = values.clone();
    }

    /**
     * Создает новый неизменяемый список из переданного списка.
     *
     * @param otherList список целых чисел, не может быть null
     * @throws NullPointerException если otherList равен null
     */
    public ImmutableValueList(List<Integer> otherList) {
        Objects.requireNonNull(otherList, "Список не может быть null");
        this.values = otherList.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Возвращает значение по указанной позиции.
     *
     * @param position индекс элемента
     * @return значение элемента
     * @throws IndexOutOfBoundsException если позиция выходит за границы списка
     */
    public int getValueAt(int position) {
        if (position < 0 || position >= values.length) {
            throw new IndexOutOfBoundsException("Неверная позиция: " + position);
        }
        return values[position];
    }

    /**
     * Создает новый список с замененным значением на указанной позиции.
     *
     * @param position индекс заменяемого элемента
     * @param newValue новое значение
     * @return новый ImmutableValueList с измененным значением
     * @throws IndexOutOfBoundsException если позиция выходит за границы списка
     */
    public ImmutableValueList replaceValueAt(int position, int newValue) {
        if (position < 0 || position >= values.length) {
            throw new IndexOutOfBoundsException("Неверная позиция: " + position);
        }
        int[] newValues = values.clone();
        newValues[position] = newValue;
        return new ImmutableValueList(newValues);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    /**
     * Проверяет, является ли список пустым.
     *
     * @return true если список пуст, false в противном случае
     */
    public boolean isEmpty() {
        return values.length == 0;
    }

    /**
     * Возвращает размер списка.
     *
     * @return количество элементов в списке
     */
    public int size() {
        return values.length;
    }

    /**
     * Возвращает копию массива значений.
     *
     * @return новый массив, содержащий все значения списка
     */
    public int[] getAll() {
        return values.clone();
    }

    /**
     * Демонстрирует использование класса ImmutableValueList.
     * Включает примеры инициализации и использования методов.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        ImmutableValueList list1 = new ImmutableValueList(1, 2, 3); // через varargs
        ImmutableValueList list2 = new ImmutableValueList(new int[]{4, 5, 6}); // через массив
        ImmutableValueList list3 = new ImmutableValueList(Arrays.asList(7, 8, 9)); // через список

        System.out.println("Список 1: " + list1);  // Выводит: [1, 2, 3]
        System.out.println("Элемент на позиции 1: " + list1.getValueAt(1)); // Выводит: 2
        System.out.println("Список 1 пустой: " + list1.isEmpty()); // Выводит: false
        System.out.println("Размер списка 1: " + list1.size()); // Выводит: 3

        ImmutableValueList newList = list1.replaceValueAt(1, 42);
        System.out.println("Новый список после замены: " + newList); // Выводит: [1, 42, 3]

        int[] allValuesArray = list1.getAll();
        System.out.println("Массив со всеми значениями списка 1: "
                + Arrays.toString(allValuesArray)); // Выводит: 1, 2, 3
    }
}