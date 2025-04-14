package p1.src.main.java;

import java.util.Arrays;

public class RadixSort {
    // Модифікований CountingSort для розрядного сортування
    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // лише 0-9 для кожного розряду

        // Підрахунок кількості входжень цифр в певному розряді
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Сума попередніх значень
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Побудова output[] з урахуванням розряду (рухаємось з кінця для стабільності)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Копіюємо output назад в arr
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Алгоритм RadixSort
    public static void radixSort(int[] arr) {
        // Шукаємо максимальне число, щоб знати кількість розрядів
        int max = Arrays.stream(arr).max().getAsInt();

        // Поступово сортуємо за кожним розрядом
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(arr, exp);
    }

    public static void main(String[] args) {
        // Створення масиву з 10 випадкових значень [0..888]
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int)(Math.random() * 889);

        System.out.println("Вхідний масив:");
        System.out.println(Arrays.toString(arr));

        // Сортування
        radixSort(arr);

        System.out.println("Вихідний масив:");
        System.out.println(Arrays.toString(arr));

        // Завдання: обрахувати суму всіх елементів відсортованого масиву
        // завдання: обчислити суму елементів масиву
        int sum = 0;
        for (int num : arr)
            sum += num;
        System.out.println("Сума елементів масиву: " + sum);
    }
}
