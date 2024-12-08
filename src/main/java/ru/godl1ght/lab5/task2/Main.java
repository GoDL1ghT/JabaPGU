package ru.godl1ght.lab5.task2;

public class Main {
    public static void main(String[] args) {
        // создаём кота
        Cat cat = new Cat("Барсик");

        // оборачиваем кота во враппер для анализа данных
        MeowingWrapper wrappedCat = new MeowingWrapper(cat);

        // отправляем "обёрнутого" кота в метод meowsCare по заданию
        Funs.meowsCare(wrappedCat);

        // после выполнения метода выводим кол-во мяуканий
        System.out.println(cat + " мяукал " + wrappedCat.getMeowCount() + " раз");
    }
}
