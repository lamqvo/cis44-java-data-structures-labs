Lab Project 1: Implementing and Comparing Search Algorithms

Objective:
This lab is designed to give you hands-on experience with the two fundamental search algorithms discussed: Linear (Sequential) Search and Binary Search. You will implement iterative versions of both and analyze their behavior.

Template Code (SearchComparison.java)

Copy and complete the following code:


public class SearchComparison {

    /**
     * Lab 1a: Iterative Linear Search
     * Searches for 'key' in the array 'arr' one element at a time.
     * @param arr The array to search (can be unsorted).
     * @param key The value to find.
     * @return The index of the key if found, otherwise -1.
     */
    public static int linearSearch(int[] arr, int key) {
        // TODO: Implement the iterative linear search algorithm.
        // Loop through the array from index 0 to the end.
        // If the element at the current index matches the key, return the index.
        
        return -1; // Return -1 if the loop finishes without finding the key.
    }

    /**
     * Lab 1b: Iterative Binary Search
     * Searches for 'key' in a sorted array 'arr' using the divide-and-conquer method.
     * @param arr The array to search (MUST be sorted).
     * @param key The value to find.
     * @return The index of the key if found, otherwise -1.
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        // TODO: Implement the iterative binary search algorithm.
        // While low is less than or equal to high:
        // 1. Calculate the middle index: mid = (low + high) / 2
        // 2. If arr[mid] matches the key, return mid.
        // 3. If the key is less than arr[mid], update 'high'.
        // 4. If the key is greater than arr[mid], update 'low'.

        return -1; // Return -1 if the loop finishes (low > high) without finding the key.
    }

    public static void main(String[] args) {
        int[] unsortedData = {22, 8, 12, 1, 9, 30, 4, 15};
        int[] sortedData =   {1, 4, 8, 9, 12, 15, 22, 30};

        System.out.println("--- Lab 1: Search Algorithm Implementation ---");

        // Test Linear Search
        System.out.println("Linear Search (Unsorted):");
        System.out.println("Find 9: Index " + linearSearch(unsortedData, 9)); // Expected: 4
        System.out.println("Find 3: Index " + linearSearch(unsortedData, 3)); // Expected: -1

        // Test Binary Search
        System.out.println("\nBinary Search (Sorted):");
        System.out.println("Find 9: Index " + binarySearch(sortedData, 9)); // Expected: 3
        System.out.println("Find 3: Index " + binarySearch(sortedData, 3)); // Expected: -1
        System.out.println("Find 30: Index " + binarySearch(sortedData, 30)); // Expected: 7
    }
}
Questions

After pasting your completed code above, please answer the following questions:
Paste the direct link to your lab10-SearchAlgorithms directory on GitHub.
What is the best-case and worst-case time complexity (O) for your linearSearch implementation?
What is the best-case and worst-case time complexity (O) for your binarySearch implementation?
Why must the array be sorted for binary search to work? What would happen if you ran your binarySearch method on the unsortedData array looking for the key 22?
Implement a simple comparisonCounter variable inside each search loop. For the sortedData array, how many comparisons does it take linearSearch to find 30 (worst-case)? How many comparisons does binarySearch take?
If an array doubled in size (from N to 2N), how would the worst-case number of comparisons for linear search change? How would it change for binary search?
Lab Project 1: Implementing and Comparing Search Algorithms

Objective:
This lab is designed to give you hands-on experience with the two fundamental search algorithms discussed: Linear (Sequential) Search and Binary Search. You will implement iterative versions of both and analyze their behavior.

Template Code (SearchComparison.java)

Copy and complete the following code:


public class SearchComparison {

    /**
     * Lab 1a: Iterative Linear Search
     * Searches for 'key' in the array 'arr' one element at a time.
     * @param arr The array to search (can be unsorted).
     * @param key The value to find.
     * @return The index of the key if found, otherwise -1.
     */
    public static int linearSearch(int[] arr, int key) {
        // TODO: Implement the iterative linear search algorithm.
        // Loop through the array from index 0 to the end.
        // If the element at the current index matches the key, return the index.
        
        return -1; // Return -1 if the loop finishes without finding the key.
    }

    /**
     * Lab 1b: Iterative Binary Search
     * Searches for 'key' in a sorted array 'arr' using the divide-and-conquer method.
     * @param arr The array to search (MUST be sorted).
     * @param key The value to find.
     * @return The index of the key if found, otherwise -1.
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        // TODO: Implement the iterative binary search algorithm.
        // While low is less than or equal to high:
        // 1. Calculate the middle index: mid = (low + high) / 2
        // 2. If arr[mid] matches the key, return mid.
        // 3. If the key is less than arr[mid], update 'high'.
        // 4. If the key is greater than arr[mid], update 'low'.

        return -1; // Return -1 if the loop finishes (low > high) without finding the key.
    }

    public static void main(String[] args) {
        int[] unsortedData = {22, 8, 12, 1, 9, 30, 4, 15};
        int[] sortedData =   {1, 4, 8, 9, 12, 15, 22, 30};

        System.out.println("--- Lab 1: Search Algorithm Implementation ---");

        // Test Linear Search
        System.out.println("Linear Search (Unsorted):");
        System.out.println("Find 9: Index " + linearSearch(unsortedData, 9)); // Expected: 4
        System.out.println("Find 3: Index " + linearSearch(unsortedData, 3)); // Expected: -1

        // Test Binary Search
        System.out.println("\nBinary Search (Sorted):");
        System.out.println("Find 9: Index " + binarySearch(sortedData, 9)); // Expected: 3
        System.out.println("Find 3: Index " + binarySearch(sortedData, 3)); // Expected: -1
        System.out.println("Find 30: Index " + binarySearch(sortedData, 30)); // Expected: 7
    }
}

Questions

After pasting your completed code above, please answer the following questions:
1. Paste the direct link to your lab10-SearchAlgorithms directory on GitHub.
2. What is the best-case and worst-case time complexity (O) for your linearSearch implementation?
3. What is the best-case and worst-case time complexity (O) for your binarySearch implementation?
4. Why must the array be sorted for binary search to work? What would happen if you ran your binarySearch method on the unsortedData array looking for the key 22?
5. Implement a simple comparisonCounter variable inside each search loop. For the sortedData array, how many comparisons does it take linearSearch to find 30 (worst-case)? How many comparisons does binarySearch take?
6. If an array doubled in size (from N to 2N), how would the worst-case number of comparisons for linear search change? How would it change for binary search?







