import java.util.Arrays;

public class MergeSort <T extends Comparable<T>>{
    T[] array;

    public MergeSort(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public T[] getArray(){
        return array;
    }
    public void mergeSort(){
        mergeSortRecursive(array);
    }

    private void mergeSortRecursive(T[] array){
        if (array.length <= 1) return;
        T[] leftArray = Arrays.copyOfRange(array,0,array.length/2);
        T[] rightArray = Arrays.copyOfRange(array,array.length/2, array.length);
        mergeSortRecursive(leftArray);
        mergeSortRecursive(rightArray);
        merge(array, leftArray, rightArray);
    }

    private void merge(T[] array, T[] leftArray, T[] rightArray) {
        int leftIndex = 0;
        int rightIndex= 0;
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
                    array[i] = rightArray[rightIndex++];;
                }
            }
        }
    }
    // Завдання 1: Сортування за спаданням
    public void mergeSortDescending() {
        mergeSortRecursiveDescending(array);
    }

    // Рекурсивний метод для сортування за спаданням
    private void mergeSortRecursiveDescending(T[] array) {
        if (array.length <= 1) return;
        T[] leftArray = Arrays.copyOfRange(array, 0, array.length / 2);
        T[] rightArray = Arrays.copyOfRange(array, array.length / 2, array.length);
        mergeSortRecursiveDescending(leftArray);
        mergeSortRecursiveDescending(rightArray);
        mergeDescending(array, leftArray, rightArray);
    }

    // Метод для злиття масивів за спаданням
    private void mergeDescending(T[] array, T[] leftArray, T[] rightArray) {
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (leftIndex == leftArray.length) {
                array[i] = rightArray[rightIndex++];
            } else if (rightIndex == rightArray.length) {
                array[i] = leftArray[leftIndex++];
            } else {
                // Порівнюємо за спаданням
                if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) >= 0) {
                    array[i] = leftArray[leftIndex++];
                } else {
                    array[i] = rightArray[rightIndex++];
                }
            }
        }
    }

    // Завдання 2: Сортування частини масиву в діапазоні [leftIndex, rightIndex]
    public void mergeSortPartial(int leftIndex, int rightIndex) {
        mergeSortRecursivePartial(array, leftIndex, rightIndex);
    }

    // Рекурсивний метод для сортування частини масиву
    private void mergeSortRecursivePartial(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return;

        int mid = (leftIndex + rightIndex) / 2;
        mergeSortRecursivePartial(array, leftIndex, mid); // ліву частину
        mergeSortRecursivePartial(array, mid + 1, rightIndex); // праву частину
        mergePartial(array, leftIndex, mid, rightIndex);
    }

    // Метод для злиття частин масиву
    private void mergePartial(T[] array, int leftIndex, int mid, int rightIndex) {
        T[] leftArray = Arrays.copyOfRange(array, leftIndex, mid + 1);
        T[] rightArray = Arrays.copyOfRange(array, mid + 1, rightIndex + 1);

        int left = 0, right = 0, k = leftIndex;
        while (left < leftArray.length && right < rightArray.length) {
            if (leftArray[left].compareTo(rightArray[right]) <= 0) {
                array[k++] = leftArray[left++];
            } else {
                array[k++] = rightArray[right++];
            }
        }
        while (left < leftArray.length) {
            array[k++] = leftArray[left++];
        }
        while (right < rightArray.length) {
            array[k++] = rightArray[right++];
        }
    }

    // Завдання 3: Порівняння часу виконання швидкого сортування та сортування злиттям
    public static void compareSortingTimes(int[] sourceArray) {
        // Час для сортування злиттям
        int[] mergeArray = Arrays.copyOf(sourceArray, sourceArray.length);
        long startTime = System.currentTimeMillis();
        MergeSort<Integer> mergeSort = new MergeSort<>(convertToIntegerArray(mergeArray));
        mergeSort.mergeSort();
        long endTime = System.currentTimeMillis();
        System.out.println("Час сортування злиттям: " + (endTime - startTime) + " мс");

        // Час для швидкого сортування
        int[] quickArray = Arrays.copyOf(sourceArray, sourceArray.length);
        startTime = System.currentTimeMillis();
        quickSort(quickArray, 0, quickArray.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Час сортування швидким алгоритмом: " + (endTime - startTime) + " мс");
    }

    private static void quickSort(int[] quickArray, int i, int i1) {
    }

    // Метод для конвертації int масиву в Integer масив
    private static Integer[] convertToIntegerArray(int[] arr) {
        Integer[] integerArray = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integerArray[i] = arr[i];
        }
        return integerArray;
    }
}
