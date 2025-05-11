package ru.godl1ght.lab2.lab.task2;

/**
 * Главный класс для демонстрации работы с сотрудниками и отделами.
 */
public class Main {
    /**
     * Основной метод программы.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Создаем сотрудников
        Employee petrov = new Employee("Петров");
        Employee kozlov = new Employee("Козлов");
        Employee sidorov = new Employee("Сидоров");

        // Создаем отдел IT и назначаем Козлова начальником
        Department itDepartment = new Department("IT", kozlov);

        // Назначаем отдел всем сотрудникам
        petrov.setDepartment(itDepartment);
        kozlov.setDepartment(itDepartment);
        sidorov.setDepartment(itDepartment);

        // Выводим информацию о сотрудниках
        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);

        // Получаем и выводим список всех сотрудников отдела через одного из сотрудников
        System.out.println("Список сотрудников отдела IT:");
        for (Employee employee : petrov.getDepartment().getEmployees()) {
            System.out.println(employee);
        }
    }
}