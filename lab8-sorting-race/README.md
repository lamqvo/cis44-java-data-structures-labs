Project 1: The Sorting Race - An Empirical Analysis of Time Complexity

Objective

This project's goal is to empirically demonstrate the performance differences between algorithms with varying time complexities. You will implement three sorting algorithms, conduct an experimental analysis by timing them with different input sizes and types (best-case, worst-case, average-case), and compare your practical results to their known theoretical complexities.

Requirements

Implement Sorting Algorithms: In Java, implement the following three sorting algorithms. You must write the code yourself, not use built-in Java sorting methods.
Research and implement selection Sort: A straightforward O(n^2) algorithm.
Research and implement insertion Sort: An O(n^2) algorithm that has a best-case performance of O(n).
Research and implement merge Sort: A more complex divide-and-conquer algorithm with O(n log n) complexity.
Create a Testing Framework: Your main method or a dedicated tester class should be able to:
Generate Test Data: Create methods to generate integer arrays of a given size n for three scenarios: Average Case (random integers), Best Case (sorted ascending), and Worst Case (sorted descending).
Time Execution: Use System.nanoTime() to accurately measure the execution time of each sorting algorithm.
Automate Testing: Run each sorting algorithm on all three data scenarios for a range of input sizes, for example: n = 1000, 5000, 10000, 25000, 50000, 100000.
Template Code

You may use the following template files as a starting point for your project.
SortingAlgorithms.java

public class SortingAlgorithms {

    /**
     * Implements the Selection Sort algorithm.
     * Theoretical Complexity: O(n^2)
     */
    public static void selectionSort(int[] arr) {
        // TODO: Implement the Selection Sort algorithm.
    }

    /**
     * Implements the Insertion Sort algorithm.
     * Theoretical Complexity: O(n^2) / Best-Case: O(n)
     */
    public static void insertionSort(int[] arr) {
        // TODO: Implement the Insertion Sort algorithm.
    }

    /**
     * Implements the Merge Sort algorithm. Public-facing method.
     * Theoretical Complexity: O(n log n)
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted
        }
        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
        // TODO: Implement the recursive logic for Merge Sort.
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // TODO: Implement the merge logic for Merge Sort.
    }
}
SortingTester.java

import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};
        
        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            
            // TODO: Call your test methods for Average, Best, and Worst cases.
        }
    }
    
    // TODO: Implement the runAndTimAllSorts helper method.

    public static int[] generateRandomArray(int size) {
        // Implementation provided in previous response
        return null;
    }

    public static int[] generateSortedArray(int size) {
        // Implementation provided in previous response
        return null;
    }

    public static int[] generateReverseSortedArray(int size) {
        // Implementation provided in previous response
        return null;
    }
}
Deliverables:

A link to the lab8-sorting-race directory on GitHub containing your java files.
Report of your results table and detailed analysis comparing empirical results to theoretical complexities.
Screenshots of plots for best, worst, and average cases.
