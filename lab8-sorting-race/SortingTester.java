import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            // TODO: Call your test methods for Average, Best, and Worst cases.
            System.out.println("\nAverage Case:");
            runAndTimeAllSorts(generateRandomArray(n));

            System.out.println("\nBest Case:");
            runAndTimeAllSorts(generateSortedArray(n));

            System.out.println("\nWorst Case:");
            runAndTimeAllSorts(generateReverseSortedArray(n));
        }
    }

    // TODO: Implement the runAndTimAllSorts helper method.
    public static void runAndTimeAllSorts(int[] original) {
        int[] arr1 = Arrays.copyOf(original, original.length);
        int[] arr2 = Arrays.copyOf(original, original.length);
        int[] arr3 = Arrays.copyOf(original, original.length);

        long start, end;

        start = System.nanoTime();
        SortingAlgorithms.selectionSort(arr1);
        end = System.nanoTime();
        System.out.println("Selection Sort: " + (end - start) + " ns");

        start = System.nanoTime();
        SortingAlgorithms.insertionSort(arr2);
        end = System.nanoTime();
        System.out.println("Insertion Sort: " + (end - start) + " ns");

        start = System.nanoTime();
        SortingAlgorithms.mergeSort(arr3);
        end = System.nanoTime();
        System.out.println("Merge Sort:     " + (end - start) + " ns");
    }

    public static int[] generateRandomArray(int size) {
        // Implementation provided in previous response
        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i<size; i++){
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        // Implementation provided in previous response
        int[] arr = new int[size];
        for (int i = 0; i<size; i++){
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        // Implementation provided in previous response
        int[] arr = new int[size];
        for (int i=0; i<size; i++){
            arr[i] = size - i;
        }
        return arr;
    }
}
