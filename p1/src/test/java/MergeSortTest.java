import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        Integer[] sourceArray = new Integer[]{5, 4, 10, 2, 1};
        Integer[] expectArray = new Integer[]{1, 2, 4, 5, 10};
        MergeSort<Integer> mergeSortAlg = new MergeSort<>(sourceArray);
        mergeSortAlg.mergeSort();
        assertThat(mergeSortAlg.getArray()).isEqualTo(expectArray);
    }
    // Завдання 1: Тест для сортування за спаданням
    @Test
    public void testMergeSortDescending() {
        Integer[] sourceArray = new Integer[]{5, 4, 10, 2, 1};
        Integer[] expectArray = new Integer[]{10, 5, 4, 2, 1};

        // Створюємо об'єкт MergeSort для масиву
        MergeSort<Integer> mergeSortAlg = new MergeSort<>(sourceArray);

        // Виконуємо сортування за спаданням
        mergeSortAlg.mergeSortDescending();

        // Перевіряємо, чи результат сортування дорівнює очікуваному
        assertThat(mergeSortAlg.getArray()).isEqualTo(expectArray);
    }

    // Завдання 2: Тест для часткового сортування
    @Test
    public void testMergeSortPartial() {
        Integer[] sourceArray = new Integer[]{5, 4, 10, 2, 1};
        Integer[] expectArray = new Integer[]{5, 2, 4, 10, 1}; // Частина від індексу 1 до 3 має бути відсортована

        // Створюємо об'єкт MergeSort для масиву
        MergeSort<Integer> mergeSortAlg = new MergeSort<>(sourceArray);

        // Виконуємо часткове сортування на діапазоні індексів від 1 до 3
        mergeSortAlg.mergeSortPartial(1, 3);

        // Перевіряємо, чи результат часткового сортування дорівнює очікуваному
        assertThat(mergeSortAlg.getArray()).isEqualTo(expectArray);
    }

    // Завдання 3: Тест для порівняння часу виконання алгоритмів
    @Test
    public void testSortingTimeComparison() {
        int[] sourceArray = new int[0];

        // Порівнюємо часи сортування злиттям та швидким сортуванням
        MergeSort.compareSortingTimes(sourceArray);

        // Цей тест не перевіряє конкретні значення, а лише виконується перевірка на виконання методів
    }
}