import java.util.Arrays;
import java.util.Random;

// Клас для реалізації базових алгоритмів сортування з підтримкою generic типів
public class BasicAlgSort<T extends Comparable<? super T>> {
    private int left;
    private int right;
    private T[] array;
    private boolean sortOrderFlag; // true - зростання, false - спадання

    // Конструктор для сортування всього масиву
    public BasicAlgSort(T[] array, boolean sortOrderFlag) {
        this.array = Arrays.copyOf(array, array.length); // Копіюємо масив
        this.sortOrderFlag = sortOrderFlag;
    }

    // Конструктор для сортування діапазону масиву (left to right)
    public BasicAlgSort(int left, int right, T[] array, boolean sortOrderFlag) {
        this.left = left;
        this.right = right;
        this.array = Arrays.copyOfRange(array, left, right); // Копіюємо діапазон
        this.sortOrderFlag = sortOrderFlag;
    }

    // Метод для отримання відсортованого масиву
    public T[] getArray() {
        return array;
    }

    // Алгоритм сортування бульбашкою (за зростанням або спаданням, залежно від прапорця)
    public void bubbleSortAsc() {
        boolean flagForInteration = true;
        while (flagForInteration) {
            flagForInteration = false;
            for (int i = 1; i < array.length; i++) {
                if (sortOrderFlag) { // true — сортування за зростанням
                    if (array[i].compareTo(array[i - 1]) < 0) {
                        swap(i, i - 1);
                        flagForInteration = true;
                    }
                } else { // false — сортування за спаданням
                    if (array[i].compareTo(array[i - 1]) > 0) {
                        swap(i, i - 1);
                        flagForInteration = true;
                    }
                }
            }
        }
    }

    // Метод обміну елементів
    private void swap(int leftIndex, int rightIndex) {
        T temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

    // Сортування вибором за зростанням
    public void selectionSortAsc() {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            T min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(min) < 0) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (i != minIndex)
                swap(i, minIndex);
        }
    }

    // Сортування вставками з лінійним пошуком (за зростанням)
    public void insertionSortWithLinearSearchAsc() {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i;
            while (j > 0 && key.compareTo(array[j - 1]) < 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;
        }
    }

    // Сортування вставками з бінарним пошуком позиції вставки
    public void insertionSortWithBinarySearchAsc() {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int leftIndex = 0;
            int rightIndex = i - 1;

            if (key.compareTo(array[i - 1]) < 0) {
                // Бінарний пошук позиції для вставки
                while (leftIndex <= rightIndex) {
                    int mid = (leftIndex + rightIndex) / 2;
                    if (key.compareTo(array[mid]) < 0) {
                        rightIndex = mid - 1;
                    } else {
                        leftIndex = mid + 1;
                    }
                }

                // Зсув елементів для вставки
                for (int j = i; j > leftIndex; j--) {
                    array[j] = array[j - 1];
                }
                array[leftIndex] = key;
            }
        }
    }

    // Швидке сортування по спаданню в межах заданого діапазону індексів
    public static void quickSortDescendingInRange(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivot = partitionDescending(arr, leftIndex, rightIndex);
            quickSortDescendingInRange(arr, leftIndex, pivot - 1); // Ліва частина
            quickSortDescendingInRange(arr, pivot + 1, rightIndex); // Права частина
        }
    }

    // Допоміжний метод для розбиття (partition) — використовується у швидкому сортуванні
    private static int partitionDescending(int[] arr, int leftIndex, int rightIndex) {
        int pivot = arr[rightIndex]; // Півот — останній елемент
        int i = leftIndex - 1;

        for (int j = leftIndex; j < rightIndex; j++) {
            if (arr[j] > pivot) { // Спадання
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Встановлення півоту у правильну позицію
        int temp = arr[i + 1];
        arr[i + 1] = arr[rightIndex];
        arr[rightIndex] = temp;

        return i + 1;
    }

    // Метод для генерації масиву випадкових чисел у діапазоні [-100, 100]
    public static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(201) - 100; // Випадкове число [-100, 100]
        }
        return arr;
    }
}
