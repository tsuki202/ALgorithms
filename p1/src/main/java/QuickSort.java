import java.util.Arrays;
import java.util.Random;

public class QuickSort <T extends Comparable <T>>{
    T[] array;
    public QuickSort(T[] array){
        this.array = Arrays.copyOf(array,array.length);
    }
    public T[] getArray(){
        return array;
    }
    public void quickSortArray(int first,int last){
        if (first < last){
            int pivotElementIndex = partition(first,last);
            quickSortArray(first,pivotElementIndex -1);
            quickSortArray(pivotElementIndex + 1,last);
        }
    }
    private int partition(int first,int last){
        T pivotElement = array[last];
        int i = first -1;
        for (int j = first; j < last; j++) {
            if (array[j].compareTo(pivotElement)<=0){
              i++;
              if(i!=j){
                  swap(i,j);
              }

            }
    }
        swap(i+1,last);
        return i+1 ;
    }
    private void swap (int i,int j){
        T firstElement = array[i];
        array[i] = array[j];
        array[j] = firstElement;
    }

    // Швидке сортування за спаданням
    public static void quickSortDescending(Integer[] arr, int low, int high) {
        if (low < high) {
            int pivot = partitionDescending(arr, low, high); // Обираємо опорний елемент
            quickSortDescending(arr, low, pivot - 1); // Сортуємо ліву частину
            quickSortDescending(arr, pivot + 1, high); // Сортуємо праву частину
        }
    }

    private static int partitionDescending(Integer[] arr, int low, int high) {
        int pivot = arr[high]; // Опорний елемент (останній елемент)
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Порівнюємо елементи для сортування за спаданням
            if (arr[j] > pivot) {
                i++;
                // Міняємо місцями елементи
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

    // Швидке сортування з центральним елементом як опорним
    public static void quickSortWithCentralPivot(Integer[] arr, int low, int high) {
        if (low < high) {
            int pivot = partitionWithCentralPivot(arr, low, high); // Опорний елемент
            quickSortWithCentralPivot(arr, low, pivot - 1); // Сортуємо ліву частину
            quickSortWithCentralPivot(arr, pivot + 1, high); // Сортуємо праву частину
        }
    }

    private static int partitionWithCentralPivot(Integer[] arr, int low, int high) {
        int mid = low + (high - low) / 2; // Центральний елемент
        int pivot = arr[mid];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Міняємо місцями елементи
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Міняємо місцями опорний елемент з елементом на індекс i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[mid];
        arr[mid] = temp;

        return i + 1;
    }

    // Швидке сортування з випадковим опорним елементом
    public static void quickSortWithRandomPivot(Integer[] arr, int low, int high) {
        if (low < high) {
            int pivot = partitionWithRandomPivot(arr, low, high); // Опорний елемент
            quickSortWithRandomPivot(arr, low, pivot - 1); // Сортуємо ліву частину
            quickSortWithRandomPivot(arr, pivot + 1, high); // Сортуємо праву частину
        }
    }

    private static int partitionWithRandomPivot(Integer[] arr, int low, int high) {
        Random rand = new Random();
        int randomIndex = low + rand.nextInt(high - low); // Вибираємо випадковий індекс
        int pivot = arr[randomIndex];

        // Міняємо місцями випадковий елемент з останнім елементом
        int temp = arr[randomIndex];
        arr[randomIndex] = arr[high];
        arr[high] = temp;

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Міняємо місцями елементи
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Міняємо місцями опорний елемент з елементом на індекс i+1
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    // Метод для порівняння часу виконання для різних опорних елементів
    public static void compareSortingTimes(Integer[] sourceArray) {
        // Масив для тестування
        Integer[] arrayForLastPivot = Arrays.copyOf(sourceArray, sourceArray.length);
        Integer[] arrayForCentralPivot = Arrays.copyOf(sourceArray, sourceArray.length);
        Integer[] arrayForRandomPivot = Arrays.copyOf(sourceArray, sourceArray.length);

        // Час для сортування з останнім елементом як опорним
        long startTime = System.currentTimeMillis();
        quickSort(arrayForLastPivot, 0, arrayForLastPivot.length - 1); // Останній елемент як опорний
        long endTime = System.currentTimeMillis();
        System.out.println("Час сортування з останнім елементом: " + (endTime - startTime) + " мс");

        // Час для сортування з центральним елементом як опорним
        startTime = System.currentTimeMillis();
        quickSortWithCentralPivot(arrayForCentralPivot, 0, arrayForCentralPivot.length - 1); // Центральний елемент
        endTime = System.currentTimeMillis();
        System.out.println("Час сортування з центральним елементом: " + (endTime - startTime) + " мс");

        // Час для сортування з випадковим елементом як опорним
        startTime = System.currentTimeMillis();
        quickSortWithRandomPivot(arrayForRandomPivot, 0, arrayForRandomPivot.length - 1); // Випадковий елемент
        endTime = System.currentTimeMillis();
        System.out.println("Час сортування з випадковим елементом: " + (endTime - startTime) + " мс");
    }

    // Швидке сортування з останнім елементом як опорним
    public static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high); // Обираємо опорний елемент
            quickSort(arr, low, pivot - 1); // Сортуємо ліву частину
            quickSort(arr, pivot + 1, high); // Сортуємо праву частину
        }
    }

    private static int partition(Integer[] arr, int low, int high) {
        int pivot = arr[high]; // Останній елемент
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
