package ru.godl1ght.lab4.task3.num3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class GenericReducer {

    // Метод для сведения списка к одному значению
    public static <T> T reduce(List<T> items, BinaryOperator<T> reducer, T identity) {
        if (items == null) {
            return identity;
        }

        T result = identity, tempResult;
        for (T item : items) {
            tempResult = reducer.apply(result, item);

            if (tempResult != null) {
                result = tempResult;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Пример 1: Объединение строк в одну строку
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        String concatenated = reduce(strings, String::concat, "");
        System.out.println("В одной строке: " + concatenated);

        // Пример 2: Сумма целых чисел
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        int sum = reduce(numbers, Integer::sum, 0);
        System.out.println("Сумма целых чисел: " + sum);

        // Пример 3: Подсчёт общего количества элементов во вложенных списках
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        List<Integer> totalCountsList = reduce(
                listOfLists,
                (acc, list) -> {
                    acc.add(list.size());
                    return acc;
                }, new ArrayList<>()
        );
        int totalCount = reduce(totalCountsList, Integer::sum, 0);
        System.out.println("Общее кол-во элементов: " + totalCount);
    }
}
