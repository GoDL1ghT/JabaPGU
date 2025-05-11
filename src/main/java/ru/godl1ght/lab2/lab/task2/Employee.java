package ru.godl1ght.lab2.lab.task2;

/**
 * Класс, представляющий сотрудника.
 */
public class Employee {
    private final String name;
    private Department department;

    /**
     * Создает нового сотрудника с указанным именем.
     *
     * @param name имя сотрудника, не должно быть null или пустым
     * @throws IllegalArgumentException если имя null или пустое
     */
    public Employee(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Имя сотрудника не может быть null или пустым");

        this.name = name;
    }

    /**
     * Назначает сотрудника в указанный отдел.
     *
     * @param department отдел для назначения, не должен быть null
     * @throws IllegalArgumentException если отдел null
     */
    public void setDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Отдел не может быть null");
        }

        if (this.department != null)
            this.department.removeEmployee(this);

        this.department = department;
        department.addEmployee(this);
    }

    /**
     * Возвращает отдел, в котором работает сотрудник.
     *
     * @return отдел сотрудника, может быть null если сотрудник не назначен в отдел
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Возвращает имя сотрудника.
     *
     * @return имя сотрудника
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (department == null)
            return name + " не назначен в отдел.";

        if (department.getManager() == this)
            return name + " начальник отдела " + department.getName();

        return name + " работает в отделе " + department.getName()
                + ", начальник которого " + department.getManager().getName();
    }

}
