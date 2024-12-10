package ru.godl1ght.lab5.task4;

import java.io.*;
import java.util.*;

public class AdmissionCheck {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\user\\IdeaProjects\\JabaPGU\\src\\main\\java\\ru\\godl1ght\\lab5\\task4\\input.txt";
        Map<String, int[]> applicants = new HashMap<>(); // Карта абитуриентов: ФИО-оценки

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int n = Integer.parseInt(reader.readLine().trim()); // Чтение количества абитуриентов

            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                if (line == null) break;

                // Разделение строки на части через сплит
                String[] parts = line.split(" ");
                if (parts.length != 5) continue;

                String fullName = parts[0] + " " + parts[1]; // ФИО
                int score1 = Integer.parseInt(parts[2]);
                int score2 = Integer.parseInt(parts[3]);
                int score3 = Integer.parseInt(parts[4]);

                // Добавляем ФИО и оценки в мапу
                applicants.put(fullName, new int[]{score1, score2, score3});
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        // Фильтрация и вывод допущенных абитуриентов
        System.out.println("Допущенные абитуриенты:");
        for (Map.Entry<String, int[]> entry : applicants.entrySet()) {
            int[] scores = entry.getValue();
            int totalScore = scores[0] + scores[1] + scores[2];

            if (scores[0] >= 30 && scores[1] >= 30 && scores[2] >= 30 && totalScore >= 140) {
                System.out.println(entry.getKey());
            }
        }
    }
}
