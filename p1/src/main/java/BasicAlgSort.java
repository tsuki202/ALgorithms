
import java.util.Arrays;
import java.util.Random;

import static java.util.Collections.swap;

public class BasicAlgSort<T extends Comparable<? super T>> {
    private int left;
    private int right;
    private T[] array;

    private boolean sortOrderFlag;



    public BasicAlgSort(T[] array,boolean sortOrderFlag){
        this.array = Arrays.copyOf(array, array.length);
        this.sortOrderFlag = sortOrderFlag;
    }

    public BasicAlgSort(int left,int right,T[] array,boolean sortOrderFlag ) {
        this.left = left;
        this.right = right;
        this.array = Arrays.copyOfRange(array,left,right);
        this.sortOrderFlag = sortOrderFlag;
        
    }
    public T[] getArray() {return array;
    }
    public void bubbleSortAsc(){
        boolean flagForInteration = true;
        while (flagForInteration){
            flagForInteration = false;
            for (int i = 1; i < array.length ; i++) {
                if (sortOrderFlag){
                    if(array[i].compareTo(array[i-1]) < 0){
                        swap(i,i-1);
                        if(!flagForInteration){
                            flagForInteration = true;
                        }
                    }
                } else {
                    if(array[i].compareTo(array[i-1]) > 0){
                        swap(i,i-1);
                        if(!flagForInteration){
                            flagForInteration = true;
                        }
                    }

                }

            }
        }
    }
    private void swap(int leftIndex,int rightIndex){
        T temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
    public void selectionSortAsc(){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            T min = array[i];
            for (int j = i+1; j < array.length ; j++) {
                if(array[j].compareTo(min) < 0){
                    min = array[j];
                    minIndex = j;
                }
            }
            if(i !=minIndex) swap(i,minIndex);
        }
    }
    public void insertionSortWithLinearSearchAsc(){
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = 1;
            for (; j > 0; j-- ){
                if (key.compareTo(array[j-1])<0){
                    array[j]= array[j-1];
                } else{
                    break;
                }
            }
            array[j] = key;
        }
    }
    public void insertionSortWithBinarySearchAsc(){
        for (int i = 1; i < array.length ; i++) {
            T key = array[i];
            int leftIndex = 0;
            int rightIndex = i -1;
            if(key.compareTo(array[i-1]) < 0){
                while (leftIndex < rightIndex){
                    int serIndex = (rightIndex + leftIndex)/ 2;
                    if(key.compareTo(array[serIndex]) <0){
                        rightIndex = serIndex;
                    }
                    else {
                        leftIndex = serIndex + 1;
                    }
                }
                for (int j = 1; j <leftIndex ; j--) {
                    array[j]= array[j-1];
                }
                array[leftIndex] = key;
            }
        }
    }

    // Метод для сортування за спаданням у заданому діапазоні індексів
    public static void quickSortDescendingInRange(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivot = partitionDescending(arr, leftIndex, rightIndex);
            quickSortDescendingInRange(arr, leftIndex, pivot - 1); // Сортуємо ліву частину
            quickSortDescendingInRange(arr, pivot + 1, rightIndex); // Сортуємо праву частину
        }
    }

    private static int partitionDescending(int[] arr, int leftIndex, int rightIndex) {
        int pivot = arr[rightIndex]; // Опорний елемент (останній)
        int i = leftIndex - 1;

        for (int j = leftIndex; j < rightIndex; j++) {
            // Сортуємо за спаданням
            if (arr[j] > pivot) {
                i++;
                // Міняємо місцями елементи
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Міняємо місцями опорний елемент з елементом на індекс i+1
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
            arr[i] = rand.nextInt(201) - 100; // Число в діапазоні [-100, 100]
        }
        return arr;
    }

}
