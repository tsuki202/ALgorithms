import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest {
    @Test
    public void testQuickSortTest(){
        Integer [] sourceArray = new Integer[] {-5,4,10,2,1,8,-5,0};
        Integer [] expectArray = new Integer[] {-5,-5,0,1,2,4,8,10};
        QuickSort<Integer> quickSortAlg = new QuickSort<>(sourceArray);
        assertThat(quickSortAlg.getArray()).isEqualTo(expectArray);

    }

    // Завдання 1: Тест для швидкого сортування за спаданням
    @Test
    public void testQuickSortDescending() {
        Integer[] sourceArray = new Integer[]{-5, 4, 10, 2, 1, 8, -5, 0};
        Integer[] expectArray = new Integer[]{10, 8, 4, 2, 1, 0, -5, -5}; // Ожидаем результат за спаданням

        QuickSort.quickSortDescending(sourceArray, 0, sourceArray.length - 1);

        assertThat(sourceArray).isEqualTo(expectArray);
    }

    // Завдання 2: Тест для швидкого сортування з центральним елементом як опорним
    @Test
    public void testQuickSortWithCentralPivot() {
        Integer[] sourceArray = new Integer[]{-5, 4, 10, 2, 1, 8, -5, 0};
        Integer[] expectArray = new Integer[]{-5, -5, 0, 1, 2, 4, 8, 10}; // Результат сортування за зростанням

        QuickSort.quickSortWithCentralPivot(sourceArray, 0, sourceArray.length - 1);

        assertThat(sourceArray).isEqualTo(expectArray);
    }

    // Завдання 3: Тест для швидкого сортування з випадковим опорним елементом
    @Test
    public void testQuickSortWithRandomPivot() {
        Integer[] sourceArray = new Integer[]{-5, 4, 10, 2, 1, 8, -5, 0};
        Integer[] expectArray = new Integer[]{-5, -5, 0, 1, 2, 4, 8, 10}; // Результат сортування за зростанням

        QuickSort.quickSortWithRandomPivot(sourceArray, 0, sourceArray.length - 1);

        assertThat(sourceArray).isEqualTo(expectArray);
    }

    // Завдання 4: Тест для порівняння часу виконання
    @Test
    public void testQuickSortPerformanceComparison() {
        Integer[] sourceArray = new Integer[]{-5, 4, 10, 2, 1, 8, -5, 0};

        // Порівняння часу для трьох різних варіантів вибору опорного елемента
        QuickSort.compareSortingTimes(sourceArray);

        // Тут ми не перевіряємо конкретний результат, оскільки ми порівнюємо час виконання,
        // але перевіряємо, чи не виникають помилки під час виконання методу.
    }
}
