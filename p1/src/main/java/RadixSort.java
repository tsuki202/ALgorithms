

import java.util.Arrays;

public class RadixSort {

    // Допоміжний метод сортування підмасиву за певною цифрою (для radix sort)
    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Масив для збереження проміжного результату
        int[] count = new int[10]; // Масив для підрахунку кількості цифр від 0 до 9

        // Заповнюємо масив count нулями
        Arrays.fill(count, 0);

        // Підрахунок кількості входжень кожної цифри на поточному розряді
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Перетворюємо count у масив накопичених сум
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Формуємо вихідний масив, заповнюючи його у зворотному порядку для стабільності
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10; // Отримуємо поточну цифру
            output[count[digit] - 1] = arr[i]; // Розміщуємо значення у правильну позицію
            count[digit]--; // Зменшуємо лічильник
        }

        // Копіюємо відсортований результат назад у вхідний масив
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Метод Radix Sort — сортування за кожною цифрою починаючи з найменш значущої
    public static void radixSort(int[] arr) {
        // Знаходимо максимальне число, щоб знати кількість розрядів
        int max = Arrays.stream(arr).max().orElse(0);

        // Сортуємо за кожним розрядом (1, 10, 100, ...)
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(arr, exp);
    }

    public static void main(String[] args) {
        // Створюємо масив з 10 випадкових чисел від 0 до 888
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int)(Math.random() * 889);

        // Вивід початкового масиву
        System.out.println("Вхідний масив:");
        System.out.println(Arrays.toString(arr));

        // Викликаємо метод сортування
        radixSort(arr);

        // Вивід відсортованого масиву
        System.out.println("Відсортований масив:");
        System.out.println(Arrays.toString(arr));

        // Завдання: обчислити суму всіх елементів у масиві
        int sum = 0;
        for (int num : arr)
            sum += num;

        System.out.println("Сума елементів масиву: " + sum);
    }
}
