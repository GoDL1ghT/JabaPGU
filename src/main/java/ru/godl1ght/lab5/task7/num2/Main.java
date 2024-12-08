package ru.godl1ght.lab5.task7.num2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // путь к файлу
        Path path = Path.of("C:\\Users\\sokol\\Desktop\\dev\\JabaPGU\\src\\main\\java\\ru\\godl1ght\\lab5\\task7\\num2\\people.txt");

        // читаем данные из файла и обрабатываем их через стрим
        try {
            // создаём стрим из строк файла
            Map<Integer, List<String>> result = Files.lines(path)
                    // разбиваем строку по двоеточию
                    .map(line -> line.split(":"))
                    // фильтр людей с номером
                    .filter(parts -> parts.length == 2 && !parts[1].isEmpty())
                    .map(parts -> {
                        String name = formatName(parts[0].trim()); // форматируем имя
                        int number = Integer.parseInt(parts[1].trim()); // парсим номер

                        // возвращаем пару имя-номер
                        return new AbstractMap.SimpleEntry<>(name, number);
                    })
                    // группируем по номерам
                    .collect(Collectors.groupingBy(
                            Map.Entry::getValue, //группировка по номеру
                            // собираем имена в список
                            Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                    ));

            // вывод результата
            System.out.println(result);

            // вывод лога при ошибке
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // метод для форматирования имени
    // первая буква заглавная, остальные - строчные
    private static String formatName(String name) {
        if (name == null || name.isEmpty()) return name;

        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
