package ru.godl1ght.lab5.task2;

public class MeowingWrapper implements Meowing {
    private Cat cat; // оригинальный кот
    private int meowCount = 0; // кол-во мяуканий

    // Конструктор который принимает кота
    public MeowingWrapper(Cat cat) {
        this.cat = cat;
    }

    // переопределение чтобы отслеживать кол-во вызовов
    @Override
    public void meow() {
        cat.meow();
        meowCount++;
    }

    // метод для получения кол-ва маяуканий
    public int getMeowCount() {
        return meowCount;
    }
}
