package ru.godl1ght.lab6.task3;

@Validate(value = {HumanTests.class})
public class Person extends Human {
    public Person(int age) {
        super(age);
    }
}
