
import java.util.Arrays;
import p1.src.main.java.RadixSort;

public class RadixSortTest {
    public static void main(String[] args) {
        int[] testArray = {345, 12, 888, 321, 55, 2, 777, 123, 8, 99};

        System.out.println("Оригінальний масив:");
        System.out.println(Arrays.toString(testArray));

        RadixSort.radixSort(testArray);  // Виклик методу сортування

        System.out.println("Масив після RadixSort:");
        System.out.println(Arrays.toString(testArray));

        int min = Arrays.stream(testArray).min().getAsInt();
        int max = Arrays.stream(testArray).max().getAsInt();
        System.out.println("Мінімум: " + min);
        System.out.println("Максимум: " + max);
    }
}
