package ru.godl1ght.lab5.task5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Имя файла
        String fileName = "C:\\Users\\user\\IdeaProjects\\JabaPGU\\src\\main\\java\\ru\\godl1ght\\lab5\\task5\\text.txt";

        try {
            // Читаем содержимое файла
            String content = Files.readString(Paths.get(fileName));

            // Разбиваем текст на слова
            String[] words = content.split("\\s+");

            // Множество для хранения уникальных символов
            Set<Character> uniqueCharacters = new HashSet<>();

            // Обрабатываем слова с чётными номерами
            for (int i = 1; i < words.length; i += 2) { // Нумерация с 0, поэтому i = 1 для слов с чётными номерами
                // Убираем все неалфавитные символы из слова
                String cleanedWord = words[i].replaceAll("[^а-яА-ЯёЁ]", "");
                for (char c : cleanedWord.toCharArray()) {
                    uniqueCharacters.add(c);
                }
            }

            // Печатаем уникальные символы
            System.out.println("Уникальные символы из слов с чётными номерами:");
            for (char c : uniqueCharacters) {
                System.out.print(c + " ");
            }

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}


