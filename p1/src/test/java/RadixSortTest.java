package p1.src.test.java;

import java.util.Arrays;

public class RadixSortTest {
    public static void main(String[] args) {
        int[] testArray = {345, 12, 888, 321, 55, 2, 777, 123, 8, 99};

        System.out.println("Оригінальний масив:");
        System.out.println(Arrays.toString(testArray));

        RadixSort.radixSort(testArray);

        System.out.println("Масив після RadixSort:");
        System.out.println(Arrays.toString(testArray));

        // Завдання: вивести мінімальне та максимальне значення
        int min = Arrays.stream(testArray).min().getAsInt();
        int max = Arrays.stream(testArray).max().getAsInt();
        System.out.println("Мінімум: " + min);
        System.out.println("Максимум: " + max);
    }
}
