public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     *      Initialize a variable maxSum to the smallest possible integer (INT_MIN).
     *      Outer Loop (i): Iterate through each element as the starting point of a subarray.
     *      Inner Loop (j): Iterate through the rest of the array (j>=i) to define the ending point of the subarray.
     *      Calculate Sum: Calculate the sum of the current subarray arr[i...j].
     *      Update Max: If the current subarray sum is greater than maxSum, update maxSum.
     *      Return maxSum after all loops finish
     */
    public static int bruteForceMaxSum(int[] arr) {
        // TODO: Implement the O(n^2) brute-force algorithm.
        if (arr.length <= 0) return 0;
        int maxSum = arr[0];
        for (int i = 0; i<arr.length; i++){
            int curSum = 0;                    // reset for each i
            for (int j = i; j < arr.length; j++){
                curSum = curSum + arr[j];           // update curSum
                if (curSum > maxSum) {
                    maxSum = curSum;                // update maxSum if curSum > maxSum
                }
            }
        }
        return maxSum; // Placeholder
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     *      Traverse the array from the second element
     *      For each element:
     *          Add it to curSum
     *          If the current element alone is greater than curSum, start new subarray
     *          Update maxSum if currentSum is greater
     *      At the end, maxSum will be the answer
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        // TODO: Implement the O(n) Kadane's Algorithm.
        if (arr.length <= 0) return 0;
        int curSum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i< arr.length; i++){
            curSum = Math.max(arr[i], curSum + arr[i] );
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum; // Placeholder
    }
}