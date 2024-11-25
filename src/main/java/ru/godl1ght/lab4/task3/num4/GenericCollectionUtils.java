package ru.godl1ght.lab4.task3.num4;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

@SuppressWarnings("ALL")
public class GenericCollectionUtils {

    public static <T, P extends Collection<T>> P transformCollection(
            List<T> sourceList,
            Supplier<P> collectionSupplier,
            BiConsumer<List<T>, P> transformLogic
    ) {
        P resultCollection = collectionSupplier.get();
        transformLogic.accept(sourceList, resultCollection);
        return resultCollection;
    }

    public static void main(String[] args) {
        // 1. Разделение чисел на положительные и отрицательные
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<List<Integer>> splitNumbers = (List<List<Integer>>) (Object) transformCollection(
                numbers,
                ArrayList::new,
                (source, resultList) -> {
                    // юзаем каст, т.к. по заданию метод принимает список типа T и
                    // возвращает коллекцию типа P с элементами типа Т.
                    // А нам нужно передать список с типом элемента int и вернуть список списков с элементами типа int
                    // А метод поддерживает только один тип возвращаемого элемента
                    List<List<Integer>> result = (List<List<Integer>>) (Object) resultList;
                    List<Integer> positives = new ArrayList<>();
                    List<Integer> negatives = new ArrayList<>();
                    for (Integer number : source) {
                        if (number > 0) {
                            positives.add(number);
                        } else {
                            negatives.add(number);
                        }
                    }
                    result.add(positives);
                    result.add(negatives);
                }
        );
        System.out.println("Разделенные числа: " + splitNumbers);

        // 2. Разделение строк по длине
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw");
        List<List<String>> groupedByLength = (List<List<String>>) (Object) transformCollection(
                strings,
                ArrayList::new,
                (source, resultList) -> {
                    List<List<String>> result = (List<List<String>>) (Object) resultList;
                    Map<Integer, List<String>> resultMap = new HashMap<>();
                    for (String str : source) {
                        resultMap.computeIfAbsent(str.length(), k -> new ArrayList<>()).add(str);
                    }
                    result.addAll(resultMap.values());
                }
        );
        System.out.println("Строки, сгруппированные по длине: " + groupedByLength);

        // 3. Уникальный набор строк
        List<String> duplicates = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");
        Set<String> uniqueSet = transformCollection(
                duplicates,
                HashSet::new,
                (source, result) -> result.addAll(source)
        );
        System.out.println("Уникальные строки: " + uniqueSet);
    }
}


