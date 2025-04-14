

import java.util.Arrays;
import p1.src.main.java.CountingSort; // Імпортуємо ваш клас CountingSort

public class CountingSortTest {
    public static void main(String[] args) {
        int[] testArray = {4, 2, 2, 8, 3, 3, 1, 7, 0, 5};

        System.out.println("Оригінальний масив:");
        System.out.println(Arrays.toString(testArray));

        CountingSort.sort(testArray);  // Виклик методу сортування

        System.out.println("Масив після CountingSort:");
        System.out.println(Arrays.toString(testArray));
    }
}
