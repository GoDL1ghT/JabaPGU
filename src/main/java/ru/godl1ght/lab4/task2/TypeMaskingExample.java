package ru.godl1ght.lab4.task2;

import java.util.List;

public class TypeMaskingExample {
    public static void fillList(List<? super Integer> list) {
        // Проверка на null
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        // Заполнение значениями от 1 до 100
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        // Пример использования с ArrayList<Integer>
        List<Integer> intList = new java.util.ArrayList<>();
        fillList(intList);
        System.out.println(intList);

        // Пример использования с ArrayList<Number>
        List<Number> numberList = new java.util.ArrayList<>();
        fillList(numberList);
        System.out.println(numberList);

        // Пример использования с ArrayList<Object>
        List<Object> objectList = new java.util.ArrayList<>();
        fillList(objectList);
        System.out.println(objectList);
    }
}

// Если параметризация будет <? extends Number>, метод не сможет добавлять элементы,
// так как компилятор не знает конкретного типа, который используется
