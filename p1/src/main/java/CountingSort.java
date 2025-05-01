

import java.util.Arrays;

public class CountingSort {

    // Метод для сортування масиву методом підрахунку (Counting Sort)
    public static void sort(int arr[]) {
        int n = arr.length; // Зберігаємо кількість елементів масиву
        if (n == 0) return; // Перевірка на випадок, якщо масив порожній

        int output[] = new int[n]; // Створюємо вихідний масив такої ж довжини, як і вхідний

        // Знаходимо максимальне значення в масиві, щоб визначити розмір масиву count
        int max = Arrays.stream(arr).max().getAsInt();

        // Створюємо масив count для підрахунку кількості входжень кожного значення
        int count[] = new int[max + 1]; // +1, бо значення можуть бути від 0 до max включно

        // Ініціалізуємо всі значення масиву count нулями (можна опустити — Java робить це автоматично)
        for (int i = 0; i < count.length; ++i)
            count[i] = 0;

        // Підраховуємо кількість входжень кожного елемента масиву
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];

        // Виводимо кількість входжень для перевірки
        System.out.println("Кількість входжень кожного елемента:");
        for (int i = 0; i < count.length; ++i)
            System.out.print(count[i] + " ");
        System.out.println();

        // Перетворюємо масив count у масив накопичених сум
        for (int i = 1; i < count.length; ++i)
            count[i] += count[i - 1];

        // Виводимо накопичені суми для перевірки
        System.out.println("Накопичені суми:");
        for (int i = 0; i < count.length; ++i)
            System.out.print(count[i] + " ");
        System.out.println();

        // Формуємо вихідний масив — перебираємо елементи в зворотному порядку для збереження стабільності
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i]; // Розміщуємо елемент на правильну позицію
            --count[arr[i]]; // Зменшуємо відповідний лічильник
        }

        // Копіюємо відсортований масив назад у вхідний
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }

    // Головний метод — створює масив, заповнює його випадковими числами, сортує і виводить результати
    public static void main(String args[]) {
        int[] arr = new int[10]; // Створюємо масив з 10 елементів
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * 11)); // Заповнюємо масив випадковими числами від 0 до 10
        }

        System.out.println("Вхідний масив:");
        System.out.println(Arrays.toString(arr)); // Виводимо масив до сортування

        sort(arr); // Викликаємо метод сортування

        System.out.println("Відсортований масив:");
        System.out.println(Arrays.toString(arr)); // Виводимо масив після сортування
    }
}
