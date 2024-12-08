package ru.godl1ght.lab5.task6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args) {
        // Создаем и заполняем очередь
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        System.out.println("Исходная очередь: " + queue);

        // Выводим элементы в обратном порядке
        printQueueInReverse(queue);
    }

    public static void printQueueInReverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Перемещаем элементы из очереди в стек
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Выводим элементы из стека
        System.out.println("Очередь в обратном порядке:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
