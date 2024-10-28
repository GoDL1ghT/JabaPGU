package ru.godl1ght.lab2.lab.task2;

import java.util.ArrayList;
import java.util.List;

class Department {
    private String name;
    private Employee manager;
    private List<Employee> employees;

    // Конструктор для создания отдела с начальником
    public Department(String name, Employee manager) {
        this.name = name;
        this.manager = manager;
        this.employees = new ArrayList<>();
        this.employees.add(manager); // Добавляем начальника в список сотрудников
    }

    // Метод для добавления сотрудника в отдел
    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    // Метод для получения списка всех сотрудников отдела
    public List<Employee> getEmployees() {
        return employees;
    }

    // Метод для получения названия отдела
    public String getName() {
        return this.name;
    }

    // Метод для получения начальника отдела
    public Employee getManager() {
        return this.manager;
    }
}

