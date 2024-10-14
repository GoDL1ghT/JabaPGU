package ru.godl1ght;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    //чётный вариант
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        //module 1
        System.out.println("\nModule 1");
        System.out.print("Введите целое число (не менее 2 знаков): ");
        int a = scanner.nextInt();
        System.out.println("1.2 | Сложение двух последних знаков числа = " + main.sumLastNums(a));

        System.out.print("Введите число: ");
        int b = scanner.nextInt();
        System.out.println("1.4 | Число положительное: " + main.isPositive(b));

        System.out.print("Введите один символ: ");
        char c = scanner.next().charAt(0);
        System.out.println("1.6 | Большая буква: " + main.isUpperCase(c));

        System.out.print("Введите первое число: ");
        int d = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int e = scanner.nextInt();
        System.out.println("1.8 | Хотя бы одно число делится на второе: " + main.isDivisor(d, e));

        System.out.print("Введите первое число: ");
        int f = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int g = scanner.nextInt();
        System.out.print("Введите третье число: ");
        int h = scanner.nextInt();
        System.out.print("Введите четвёртое число: ");
        int i = scanner.nextInt();
        System.out.print("Введите пятое число: ");
        int j = scanner.nextInt();
        System.out.println("1.10 | Итого: " +
                main.lastNumSum(
                        main.lastNumSum(
                                main.lastNumSum(
                                        main.lastNumSum(
                                                f, g), h), i), j));


        //module 2
        System.out.println("\nModule 2");
        System.out.print("Введите первое число: ");
        int k = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int l = scanner.nextInt();
        System.out.println("2.2 | Безопасное деление двух чисел = " + main.safeDiv(k, l));

        System.out.print("Введите первое число: ");
        int m = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int n = scanner.nextInt();
        System.out.println("2.4 | Результат: " + main.makeDecision(m, n));

        System.out.print("Введите первое число: ");
        int o = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int p = scanner.nextInt();
        System.out.print("Введите третье число: ");
        int q = scanner.nextInt();
        System.out.println("2.6 | Результат: " + main.sum3(o, p, q));

        System.out.print("Введите число: ");
        int r = scanner.nextInt();
        System.out.println("2.8 | Результат: " + main.age(r));

        System.out.print("Введите день недели: ");
        String s = scanner.next();
        System.out.println("2.10 | Результат: ");
        main.printDays(s);

        //module 3
        System.out.println("\nModule 3");
        System.out.print("Введите число: ");
        int t = scanner.nextInt();
        System.out.println("3.2 | Результат: " + main.reverseListNums(t));

        System.out.print("Введите число: ");
        int u = scanner.nextInt();
        System.out.print("Введите степень: ");
        int v = scanner.nextInt();
        System.out.println("3.4 | Результат: " + main.pow(u, v));

        System.out.print("Введите число: ");
        int w = scanner.nextInt();
        System.out.println("3.6 | Все знаки числа одинаковы: " + main.equalNum(w));

        System.out.print("Введите число рядов: ");
        int x = scanner.nextInt();
        System.out.println("3.8 | Результат:");
        main.leftTriangle(x);

        System.out.println("3.10 | Игра: ");
        main.guessGame(); // task 10


        //module 4
        //Task 4.2
        System.out.println("\nModule 4");
        System.out.print("Введите размерность массива: ");
        int arr1Size = scanner.nextInt();
        int[] arr1 = new int[arr1Size];
        for (int i1 = 0; i1 < arr1Size; i1++) {
            arr1[i1] = rand.nextInt(5);
        }
        System.out.print("Введите число: ");
        int num1 = scanner.nextInt();
        System.out.print("Массив: ");
        for (int value : arr1) {
            System.out.print(value + " ");
        }
        System.out.println("\n4.2 | Результат: " + main.findLast(arr1, num1));


        //Task 4.4
        System.out.print("Введите размерность массива: ");
        int arr2Size = scanner.nextInt();
        int[] arr2 = new int[arr2Size];
        for (int i22 = 0; i22 < arr2Size; i22++) {
            arr2[i22] = rand.nextInt(5);
        }
        System.out.print("Введите число: ");
        int num2 = scanner.nextInt();
        System.out.print("Введите позицию: ");
        int pos2 = scanner.nextInt();
        System.out.print("Массив: ");
        for (int j2 : arr2) {
            System.out.print(j2 + " ");
        }
        System.out.println("\n4.4 | Результат: " + Arrays.toString(main.add(arr2, num2, pos2)));


        //Task 4.6
        System.out.print("Введите размерность массива: ");
        int arr3Size = scanner.nextInt();
        int[] arr3 = new int[arr3Size];
        for (int i111 = 0; i111 < arr3Size; i111++) {
            arr3[i111] = rand.nextInt(5);
        }
        System.out.print("Массив: ");
        for (int j22 : arr3) {
            System.out.print(j22 + " ");
        }
        main.reverse(arr3);
        System.out.println("\n4.6 | Результат: " + Arrays.toString(arr3));


        //Task 4.8
        System.out.print("Введите размерность массивов: ");
        int arr4Size = scanner.nextInt();
        int[] arr4 = new int[arr4Size];
        int[] arr44 = new int[arr4Size];
        for (int i4 = 0; i4 < arr4Size; i4++) {
            arr4[i4] = rand.nextInt(5);
            arr44[i4] = rand.nextInt(5);
        }
        System.out.print("Массив 1: ");
        for (int j4 : arr4) {
            System.out.print(j4 + " ");
        }
        System.out.print("\nМассив 2: ");
        for (int k4 : arr44) {
            System.out.print(k4 + " ");
        }
        System.out.println("\n4.8 | Результат: " + Arrays.toString(main.concat(arr4, arr44)));


        //Task 4.10
        System.out.print("Введите размерность массива: ");
        int arr5Size = scanner.nextInt();
        int[] arr5 = new int[arr5Size];
        for (int i5 = 0; i5 < arr5Size; i5++) {
            if (rand.nextBoolean()) arr5[i5] = rand.nextInt(arr5Size);
            else arr5[i5] = -rand.nextInt(arr5Size);
        }
        System.out.print("Массив: ");
        for (int j5 : arr5) {
            System.out.print(j5 + " ");
        }
        System.out.println("\n4.10 | Результат: " + Arrays.toString(main.deleteNegative(arr5)));
    }

    //module 1
    public int sumLastNums(int x) {
        int lastDigit = x % 10;
        x = x / 10;
        int secondLastDigit = x % 10;
        return lastDigit + secondLastDigit;
    }

    public boolean isPositive(int x) {
        return x > 0;
    }

    public boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }

    public boolean isDivisor(int a, int b) {
        return (b != 0 && a % b == 0) || (a != 0 && b % a == 0);
    }

    public int lastNumSum(int a, int b) {
        return (a % 10) + (b % 10);
    }

    //module 2
    public double safeDiv(int x, int y) {
        if (y == 0) return 0;
        return (double) x / y;
    }

    public String makeDecision(int x, int y) {
        if (x > y)
            return x + " > " + y;
        else if (x < y)
            return x + " < " + y;
        else
            return x + " == " + y;
    }

    public boolean sum3(int x, int y, int z) {
        return (x + y == z) || (x + z == y) || (y + z == x);
    }

    public String age(int x) {
        String suffix;
        int lastDigit = x % 10;
        int lastTwoDigits = x % 100;

        if (lastDigit == 1 && lastTwoDigits != 11)
            suffix = "год";
        else if (lastDigit >= 2 && lastDigit <= 4 && (lastTwoDigits < 12 || lastTwoDigits > 14))
            suffix = "года";
        else
            suffix = "лет";

        return x + " " + suffix;
    }

    public void printDays(String x) {
        switch (x) {
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресенье");
                break;
            default:
                System.out.println("это не день недели");
        }
    }

    //module 3
    public String reverseListNums(int x) {
        StringBuilder result = new StringBuilder();

        for (int i = x; i >= 0; i--) {
            result.append(i);
            if (i > 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public int pow(int x, int y) {
        int result = 1;

        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }

    public boolean equalNum(int x) {
        if (x < 10)
            return true;

        int lastDigit = x % 10;

        while (x > 0) {
            int currentDigit = x % 10;
            if (currentDigit != lastDigit)
                return false;
            x /= 10;
        }
        return true;
    }

    public void leftTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void guessGame() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        Scanner scanner = new Scanner(System.in);
        int userGuess;
        int attempts = 0;

        do {
            System.out.print("Введите число от 0 до 9: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber)
                System.out.println("Вы угадали!");
            else
                System.out.println("Вы не угадали, введите число от 0 до 9:");

        } while (userGuess != randomNumber);

        System.out.println("Вы отгадали число за " + attempts + " попытки!");
    }

    //module 4
    public int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    public int[] add(int[] arr, int x, int pos) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }

        newArr[pos] = x;

        for (int i = pos + 1; i < newArr.length; i++) {
            newArr[i] = arr[i - 1];
        }
        return newArr;
    }

    public void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public int[] concat(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }
        return result;
    }

    public int[] deleteNegative(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num >= 0)
                count++;
        }

        int[] result = new int[count];
        int index = 0;

        for (int num : arr) {
            if (num >= 0)
                result[index++] = num;
        }
        return result;
    }
}