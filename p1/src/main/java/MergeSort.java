import java.util.Arrays;

// Клас MergeSort для узагальненого сортування масивів
public class MergeSort <T extends Comparable<T>>{
    T[] array;

    // Конструктор: копіює переданий масив
    public MergeSort(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    // Метод для отримання відсортованого масиву
    public T[] getArray(){
        return array;
    }

    // Публічний метод для запуску сортування
    public void mergeSort(){
        mergeSortRecursive(array);
    }

    // Рекурсивне злиття масиву (звичайне сортування за зростанням)
    private void mergeSortRecursive(T[] array){
        if (array.length <= 1) return;

        T[] leftArray = Arrays.copyOfRange(array, 0, array.length/2);
        T[] rightArray = Arrays.copyOfRange(array, array.length/2, array.length);

        mergeSortRecursive(leftArray);
        mergeSortRecursive(rightArray);
        merge(array, leftArray, rightArray);
    }

    // Метод злиття двох частин масиву у відсортованому порядку
    private void merge(T[] array, T[] leftArray, T[] rightArray) {
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < array.length; i++){
            if (leftIndex == leftArray.length){
                array[i] = rightArray[rightIndex++];
            }
            else if (rightIndex == rightArray.length){
                array[i] = leftArray[leftIndex++];
            }else {
                if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0){
                    array[i] = leftArray[leftIndex++];
                }else {
                    array[i] = rightArray[rightIndex++];
                }
            }
        }
    }

    // Завдання 1: Сортування у порядку спадання
    public void mergeSortDescending() {
        mergeSortRecursiveDescending(array);
    }

    // Рекурсивний метод сортування за спаданням
    private void mergeSortRecursiveDescending(T[] array) {
        if (array.length <= 1) return;

        T[] leftArray = Arrays.copyOfRange(array, 0, array.length / 2);
        T[] rightArray = Arrays.copyOfRange(array, array.length / 2, array.length);

        mergeSortRecursiveDescending(leftArray);
        mergeSortRecursiveDescending(rightArray);
        mergeDescending(array, leftArray, rightArray);
    }

    // Злиття масивів у порядку спадання
    private void mergeDescending(T[] array, T[] leftArray, T[] rightArray) {
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (leftIndex == leftArray.length) {
                array[i] = rightArray[rightIndex++];
            } else if (rightIndex == rightArray.length) {
                array[i] = leftArray[leftIndex++];
            } else {
                if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) >= 0) {
                    array[i] = leftArray[leftIndex++];
                } else {
                    array[i] = rightArray[rightIndex++];
                }
            }
        }
    }

    // Завдання 2: Сортування частини масиву у діапазоні [leftIndex, rightIndex]
    public void mergeSortPartial(int leftIndex, int rightIndex) {
        // Перевірка на валідність введених індексів
        if (leftIndex < 0 || rightIndex >= array.length || leftIndex > rightIndex) {
            throw new IllegalArgumentException("Invalid range");
        }
        mergeSortRecursivePartial(array, leftIndex, rightIndex);
    }

    // Рекурсивне сортування частини масиву
    private void mergeSortRecursivePartial(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return;

        int mid = leftIndex + (rightIndex - leftIndex) / 2;
        mergeSortRecursivePartial(array, leftIndex, mid);
        mergeSortRecursivePartial(array, mid + 1, rightIndex);
        mergePartial(array, leftIndex, mid, rightIndex);
    }

    // Злиття частин масиву
    private void mergePartial(T[] array, int leftIndex, int mid, int rightIndex) {
        T[] leftArray = Arrays.copyOfRange(array, leftIndex, mid + 1);
        T[] rightArray = Arrays.copyOfRange(array, mid + 1, rightIndex + 1);

        int i = 0, j = 0, k = leftIndex;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Копіюємо залишки
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

    // Завдання 3: Порівняння часу виконання сортування злиттям та швидкого сортування
    public static void compareSortingTimes(int[] sourceArray) {
        // Merge sort
        int[] mergeArray = Arrays.copyOf(sourceArray, sourceArray.length);
        long startTime = System.currentTimeMillis();
        MergeSort<Integer> mergeSort = new MergeSort<>(convertToIntegerArray(mergeArray));
        mergeSort.mergeSort();
        long endTime = System.currentTimeMillis();
        System.out.println("Час сортування злиттям: " + (endTime - startTime) + " мс");

        // Quick sort
        int[] quickArray = Arrays.copyOf(sourceArray, sourceArray.length);
        startTime = System.currentTimeMillis();
        quickSort(quickArray, 0, quickArray.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Час швидкого сортування: " + (endTime - startTime) + " мс");
    }

    // Швидке сортування
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    // Розбиття для швидкого сортування
    private static int partition(int[] arr, int low, int high) {
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

    // Перетворення int[] у Integer[]
    private static Integer[] convertToIntegerArray(int[] arr) {
        Integer[] integerArray = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integerArray[i] = arr[i];
        }
        return integerArray;
    }
}
