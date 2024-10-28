package ru.godl1ght.lab2.lab.task2;

// Объединения задач 2.4 и 3.4
public class Main {
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
        System.out.println("\nСписок сотрудников отдела IT:");
        for (Employee employee : petrov.getDepartment().getEmployees()) {
            System.out.println(employee);
        }
    }
}