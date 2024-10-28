package ru.godl1ght.lab2.lab.task2;

class Employee {
    private String name;
    private Department department;

    // Конструктор для создания сотрудника без указания отдела
    public Employee(String name) {
        this.name = name;
    }

    // Метод для назначения отдела сотруднику
    public void setDepartment(Department department) {
        this.department = department;
        department.addEmployee(this); // Добавляем сотрудника в отдел
    }

    // Метод для получения отдела сотрудника
    public Department getDepartment() {
        return this.department;
    }

    @Override
    public String toString() {
        if (this.department != null && this.department.getManager() == this) {
            return this.name + " начальник отдела " + this.department.getName();
        } else if (this.department != null) {
            return this.name + " работает в отделе " + this.department.getName() +
                    ", начальник которого " + this.department.getManager().name;
        } else {
            return this.name + " не назначен в отдел.";
        }
    }
}
