import java.util.Arrays;

public class SortingAlgorithms {
    /**
     * Implements the Selection Sort algorithm.
     * Theoretical Complexity: O(n^2)
     *      Pick position i
     *      Find the smallest element in i → end
     *      Swap it with i
     *      Repeat
     */
    public static void selectionSort(int[] arr) {
        // TODO: Implement the Selection Sort algorithm.
//        System.out.println("Original arr = " + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;                           // set i position as minIndex
            for (int j = i+1; j < arr.length; j++){     // inner loop starting at j = i + 1
                if (arr[j] < arr[minIndex]){            // if arr[j] < element at minIndex
                    minIndex = j;                       // set minIndex = j
                }
            }
            if (minIndex != i){                         // if minIndex is not i
                int tmp = arr[minIndex];                // set tmp as minIndex element value
                arr[minIndex] = arr[i];                 // set arr[minIndex] = current element
                arr[i] = tmp;                           // set current element = tmp
            }
//            System.out.println("Selection A = " + Arrays.toString(arr));
        }
//        System.out.println("Selection A = " + Arrays.toString(arr));
    }

    /**
     * Implements the Insertion Sort algorithm.
     * Theoretical Complexity: O(n^2) / Best-Case: O(n)
     *      Start at the second element: Assume the first element (index 0) is already sorted.
     *      Pick an element: Take the next element (the "key") from the unsorted portion.
     *      Compare and Shift: Compare the key with elements in the sorted portion (to its left).
     *          Shift elements in the sorted portion that are greater than the key one position to the right.
     *      Insert: Insert the key into its correct position.
     *      Repeat: Repeat until the entire array is sorted.
     */
    public static void insertionSort(int[] arr) {
        // TODO: Implement the Insertion Sort algorithm.
//        System.out.println("Original arr = " + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++){
            int key = arr[i];                   // pick key element = arr[i]
            int j = i - 1;                      // set j as previous element index
            while (j >= 0 && arr[j] > key){     // while previous >= 0 && element at this index is greater than key
                arr[j+1] = arr[j];              // shift element to right
                j--;                            // decremental j
            }
            arr[j+1] = key;                     // insert key element to the left
        }
//        System.out.println("Insertion A = " + Arrays.toString(arr));
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
//        System.out.println("Original A = " + Arrays.toString(arr));
        // Base case
        if (left >= right) return;
        int mid = left + (right - left) / 2;        // middle index of the array
        // Sort left half
        mergeSortRecursive(arr, temp, left, mid);
        // Sort right half
        mergeSortRecursive(arr, temp, mid + 1, right);
        // Merge the 2 sorted halves
        merge(arr, temp, left, mid, right);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // TODO: Implement the merge logic for Merge Sort.
        int i = left;    // pointer for left half
        int j = mid + 1; // pointer for right half
        int k = left;   // pointer for temp array
        // compare & copy the smallest element value into temp array
        while (i <= mid && j <= right) {    // while i is in left half && j is in right half
            if (arr[i] <= arr[j]){          // if element value on left is smaller than right
                temp[k] = arr[i];           // copy value of element on left to temp at index k
                i++;                        // increase i index up
            }
            else {
                temp[k] = arr[j];           // copy value of element on right to temp at index k
                j++;                        // increase j index up
            }
            k++;                            // increase k index up
        }
        // Copy remaining elements from left half
        while (i <= mid){
            temp[k] = arr[i];               // copy value of element on left to temp at index k
            i++;                            // increase i index up
            k++;                            // increase k index up
        }
        // Copy remaining elements from right half
        while (j <= right){
            temp[k] = arr[j];               // copy value of element on right to temp at index k
            j++;                            // increase j index up
            k++;                            // increase k index up
        }
        // copy merged result from temp back to original array
        for (int index = left; index <= right; index++){
            arr[index] = temp[index];
        }
    }
}
