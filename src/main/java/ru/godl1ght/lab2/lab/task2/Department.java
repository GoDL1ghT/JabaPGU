package ru.godl1ght.lab2.lab.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс, представляющий отдел в организации.
 */
public class Department {
    private final String name;
    private final Employee manager;
    private final List<Employee> employees;

    /**
     * Создает новый отдел с указанным названием и менеджером.
     *
     * @param name    название отдела, не должно быть null или пустым
     * @param manager менеджер отдела, не должен быть null
     * @throws IllegalArgumentException если name или manager null, или name пустое
     */
    public Department(String name, Employee manager) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Название отдела не может быть null или пустым");

        if (manager == null)
            throw new IllegalArgumentException("Менеджер отдела не может быть null");


        this.name = name;
        this.manager = manager;
        this.employees = new ArrayList<>();
        this.employees.add(manager);
    }

    /**
     * Добавляет сотрудника в отдел.
     *
     * @param employee сотрудник для добавления, не должен быть null
     * @throws IllegalArgumentException если employee null
     */
    public void addEmployee(Employee employee) {
        if (employee == null)
            throw new IllegalArgumentException("Сотрудник не может быть null");

        if (!employees.contains(employee))
            employees.add(employee);
    }

    /**
     * Удаляет сотрудника из отдела.
     *
     * @param employee сотрудник для удаления, не должен быть null
     * @throws IllegalArgumentException если employee null
     */
    public void removeEmployee(Employee employee) {
        if (employee == null)
            throw new IllegalArgumentException("Сотрудник не может быть null");

        employees.remove(employee);
    }

    /**
     * Возвращает неизменяемый список всех сотрудников отдела.
     *
     * @return неизменяемый список сотрудников
     */
    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    /**
     * Возвращает название отдела.
     *
     * @return название отдела
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает менеджера отдела.
     *
     * @return менеджер отдела
     */
    public Employee getManager() {
        return manager;
    }

}
