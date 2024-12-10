package ru.godl1ght.lab5.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueList {
    public static void main(String[] args) {
//        List<Integer> L = Arrays.asList(1, 1, 2, 2, 2, 3, 4, 4, 5, 5, 5, 5, 6);
        List<String> L = List.of("a", "a", "b", "b", "c", "c", "c", "d", "e", "e");

        // Обработка списка через вызов метода
        List<String> result = removeDuplicates(L);

        System.out.println("Исходный список: " + L);
        System.out.println("Результат: " + result);
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }

        List<T> result = new ArrayList<>();
        // Добавляем первый элемент
        result.add(list.get(0));

        // Идем по списку и добавляем только отличающиеся элементы
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i).equals(list.get(i - 1))) {
                result.add(list.get(i));
            }
        }

        return result;
    }
}

