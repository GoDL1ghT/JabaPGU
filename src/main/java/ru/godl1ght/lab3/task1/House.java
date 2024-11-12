package ru.godl1ght.lab3.task1;

public class House {
    private final int floors;

    public House(int floors) {
        if (floors < 1)
            throw new IllegalArgumentException("Количество этажей не может быть меньше 1!");

        this.floors = floors;
    }

    private String getFloorTextForm() {
        int lastDigit = floors % 10;

        if (lastDigit == 1) return floors + " этажом";
        else return floors + " этажами";
    }

    @Override
    public String toString() {
        return "Дом с " + getFloorTextForm();
    }

    public static void main(String[] args) {
        try {
            House house1 = new House(1);
            House house5 = new House(5);
            House house23 = new House(23);
            House house0 = new House(0);

            System.out.println(house1);
            System.out.println(house5);
            System.out.println(house23);
            System.out.println(house0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
