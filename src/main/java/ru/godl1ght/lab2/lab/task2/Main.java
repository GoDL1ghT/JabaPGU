package ru.godl1ght.lab2.lab.task2;

/**
 * Главный класс для демонстрации работы с сотрудниками и отделами.
 */
public class Main {
    public static void main(String[] args) {
        Employee petrov = new Employee("Петров");
        Employee kozlov = new Employee("Козлов");
        Employee sidorov = new Employee("Сидоров");

        Department itDepartment = new Department("IT", kozlov);

        petrov.setDepartment(itDepartment);
        kozlov.setDepartment(itDepartment);
        sidorov.setDepartment(itDepartment);

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