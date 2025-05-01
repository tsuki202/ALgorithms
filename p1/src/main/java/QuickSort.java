import java.util.Arrays;
import java.util.Random;

// Клас, який реалізує алгоритм швидкого сортування (QuickSort)
public class QuickSort <T extends Comparable <T>> {
    T[] array;

    // Конструктор, що копіює вхідний масив
    public QuickSort(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    // Геттер для масиву
    public T[] getArray() {
        return array;
    }

    // Рекурсивне швидке сортування з останнім елементом як опорним
    public void quickSortArray(int first, int last) {
        if (first < last) {
            int pivotElementIndex = partition(first, last); // Отримуємо індекс опорного елемента
            quickSortArray(first, pivotElementIndex - 1);   // Сортуємо ліву частину
            quickSortArray(pivotElementIndex + 1, last);    // Сортуємо праву частину
        }
    }

    // Розбиття масиву навколо опорного елемента
    private int partition(int first, int last) {
        T pivotElement = array[last]; // Вибираємо останній елемент як опорний
        int i = first - 1;

        for (int j = first; j < last; j++) {
            // Якщо поточний елемент менший або дорівнює опорному
            if (array[j].compareTo(pivotElement) <= 0) {
                i++;
                if (i != j) {
                    swap(i, j); // Міняємо місцями
                }
            }
        }

        // Ставимо опорний елемент на своє місце
        swap(i + 1, last);
        return i + 1;
    }

    // Метод обміну елементів масиву
    private void swap(int i, int j) {
        T firstElement = array[i];
        array[i] = array[j];
        array[j] = firstElement;
    }

    // Швидке сортування за спаданням
    public static void quickSortDescending(Integer[] arr, int low, int high) {
        if (low < high) {
            int pivot = partitionDescending(arr, low, high);
            quickSortDescending(arr, low, pivot - 1);
            quickSortDescending(arr, pivot + 1, high);
        }
    }

    // Розбиття для сортування за спаданням
    private static int partitionDescending(Integer[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Швидке сортування з центральним опорним елементом
    public static void quickSortWithCentralPivot(Integer[] arr, int low, int high) {
        if (low < high) {
            int pivot = partitionWithCentralPivot(arr, low, high);
            quickSortWithCentralPivot(arr, low, pivot - 1);
            quickSortWithCentralPivot(arr, pivot + 1, high);
        }
    }

    // Розбиття з центральним опорним елементом
    private static int partitionWithCentralPivot(Integer[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivotValue = arr[mid];

        // Міняємо місцями центральний елемент та останній
        arr[mid] = arr[high];
        arr[high] = pivotValue;

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivotValue) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Швидке сортування з випадковим опорним елементом
    public static void quickSortWithRandomPivot(Integer[] arr, int low, int high) {
        if (low < high) {
            int pivot = partitionWithRandomPivot(arr, low, high);
            quickSortWithRandomPivot(arr, low, pivot - 1);
            quickSortWithRandomPivot(arr, pivot + 1, high);
        }
    }

    // Розбиття з випадковим опорним елементом
    private static int partitionWithRandomPivot(Integer[] arr, int low, int high) {
        Random rand = new Random();
        int randomIndex = low + rand.nextInt(high - low + 1);

        int pivotValue = arr[randomIndex];

        // Міняємо місцями випадковий елемент та останній
        arr[randomIndex] = arr[high];
        arr[high] = pivotValue;

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivotValue) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Порівняння часу сортування для різних опорних елементів
    public static void compareSortingTimes(Integer[] sourceArray) {
        Integer[] arrayForLastPivot = Arrays.copyOf(sourceArray, sourceArray.length);
        Integer[] arrayForCentralPivot = Arrays.copyOf(sourceArray, sourceArray.length);
        Integer[] arrayForRandomPivot = Arrays.copyOf(sourceArray, sourceArray.length);

        long startTime = System.currentTimeMillis();
        quickSort(arrayForLastPivot, 0, arrayForLastPivot.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Час сортування з останнім елементом: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        quickSortWithCentralPivot(arrayForCentralPivot, 0, arrayForCentralPivot.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Час сортування з центральним елементом: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        quickSortWithRandomPivot(arrayForRandomPivot, 0, arrayForRandomPivot.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Час сортування з випадковим елементом: " + (endTime - startTime) + " мс");
    }

    // Класичне швидке сортування з останнім елементом як опорним
    public static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    // Розбиття для класичного сортування
    private static int partition(Integer[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
