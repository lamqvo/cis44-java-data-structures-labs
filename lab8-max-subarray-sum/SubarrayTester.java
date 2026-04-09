import java.util.Arrays;
import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
//        int[] sizes = {5, 10, 20};
        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            // TODO: Generate a random array and time both algorithms.
            int[] arr = generateRandomArrayWithNegatives(n);
//            System.out.println(Arrays.toString(arr));

            // Time BruteForce
            long startBrute = System.nanoTime();
            int bruteResult = MaxSubarraySolver.bruteForceMaxSum(arr);
            long endBrute = System.nanoTime();
            long bruteTime = endBrute - startBrute;

            // Time Kadane's algorithm
            long startKadane = System.nanoTime();
            int kadaneResult = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            long endKadane = System.nanoTime();
            long kadaneTime = endKadane - startKadane;

            System.out.println("\tBrute Force result = " + bruteResult);
            System.out.println("\tKadane result = " + kadaneResult);
            System.out.println("\tBrute Force Time: " + bruteTime + " ns");
            System.out.println("\tKadane Time: " + kadaneTime + " ns");
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        // Implementation provided in previous response
        Random random = new Random();
        int[] arr = new int[size];
        int min = -100;
        int max = 100;
        for (int i = 0; i<size; i++){
            arr[i] = random.nextInt(max - min + 1) + min;   //Formula: nextInt(range) + offset
        }
        return arr;
    }
}
