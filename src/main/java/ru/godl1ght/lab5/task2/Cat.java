package ru.godl1ght.lab5.task2;

public class Cat implements Meowing {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Кот " + name;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }
}
