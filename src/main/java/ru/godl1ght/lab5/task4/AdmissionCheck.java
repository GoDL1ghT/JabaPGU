package ru.godl1ght.lab5.task4;

import java.io.*;
import java.util.*;

public class AdmissionCheck {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\user\\IdeaProjects\\JabaPGU\\src\\main\\java\\ru\\godl1ght\\lab5\\task4\\input.txt"; // Имя входного файла
        List<String> admittedStudents = new ArrayList<>(); // Список допущенных студентов

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int n = Integer.parseInt(reader.readLine().trim()); // Чтение количества абитуриентов

            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                if (line == null) break;

                // Разделение строки на части
                String[] parts = line.split(" ");
                if (parts.length != 5) continue;

                String lastName = parts[0];
                String firstName = parts[1];
                int score1 = Integer.parseInt(parts[2]);
                int score2 = Integer.parseInt(parts[3]);
                int score3 = Integer.parseInt(parts[4]);

                // Проверка условий допуска
                if (score1 >= 30 && score2 >= 30 && score3 >= 30 && (score1 + score2 + score3) >= 140) {
                    admittedStudents.add(lastName + " " + firstName);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        // Вывод списка допущенных абитуриентов
        System.out.println("Допущенные абитуриенты:");
        for (String student : admittedStudents) {
            System.out.println(student);
        }
    }
}

