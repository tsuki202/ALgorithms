package p1.src.main.java;

import java.util.Arrays;
public class CountingSort {
    public static void sort(int arr[]) {
        int n = arr.length; // записуємо у змінну n кількість елементів масиву
        int output[] = new int[n]; // створюємо вихідний масив на n елементів
// створюємо додатковий масив для підрахунку кількості повторень
// елементів та наповнюємо його "0"
        int count[] = new int[11];
        for (int i = 0; i < count.length; ++i)
            count[i] = 0;
// проводимо підрахунок повторюваності елементів у масиві що подано на
// сортування
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];
// вивід у консоль значень кількості повторюваності елементів у масиві
// для перевірки працездатності коду
        System.out.println("Значення повторюавності елементів у масиві: ");
        for (int i = 0; i < n; ++i)
            System.out.print(count[i] + " ");
        System.out.println();
// сумуємо значення комірок count[i] та count[i-1]
        for (int i = 1; i <= 10; ++i)
            count[i] += count[i - 1];
// вивід у консоль значень суми комірок [i] та [i-1] для перевірки
// працездатності коду
        System.out.println("Значення суми count[i] та count[i-1]: ");
        for (int i = 0; i < n; ++i)
            System.out.print(count[i] + " ");
        System.out.println();
// побудова вихідного масиву із одночасним зменшенням значення комірки
// [i] масиву count на 1
        for (int i = 0; i < n; ++i) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }
    // головний метод: створює масив на 10 елементів, наповнює його випадковими
// значеннями, викликає метод сортування та виводить у консоль вхідний і
// вихідний варіанти масиву
    public static void main(String args[]) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * 11));
        }
        System.out.println("Вхідний масив: ");
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println("Вихідний масив: ");
        System.out.println(Arrays.toString(arr));
    }
}

