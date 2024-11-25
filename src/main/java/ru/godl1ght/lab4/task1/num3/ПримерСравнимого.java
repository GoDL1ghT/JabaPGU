package ru.godl1ght.lab4.task1.num3;

class ПримерСравнимого implements Сравнимое<String> {
    @Override
    public int сравнить(String объект) {
        // Сравнение строк по длине
        return this.toString().length() - объект.length();
    }

    @Override
    public String toString() {
        return "Пример строки";
    }
}
