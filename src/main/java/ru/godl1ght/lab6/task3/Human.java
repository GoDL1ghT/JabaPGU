package ru.godl1ght.lab6.task3;

@Validate(value = {HumanTests.class})
public class Human {
    private int age;

    public Human(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Возраст человека = " + age;
    }
}
