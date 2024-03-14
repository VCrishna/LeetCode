class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Initialize count to keep track of the number of
        // subarrays with the sum equal to 'goal'
        int count = 0;
        // Initialize sum to keep track of the
        // cumulative sum of elements in the array
        int sum = 0;
        // Creating a HashMap to store the count of each prefix sum encountered
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // Initialize the HashMap with a single entry (0, 1),
        // representing an empty subarray
        prefixSumCount.put(0, 1);

        // Iterating through the elements of the 'nums' array
        for (int num : nums) {
            // Updating 'sum' by adding the current element
            sum += num;
            // Calculating the target sum needed to reach the 'goal'
            int targetSum = sum - goal;
            // Incrementing 'count' by the count of subarrays
            // with the target sum encountered before
            count += prefixSumCount.getOrDefault(targetSum, 0);
            // Updating the count of the current sum
            // encountered in the 'prefixSumCount' HashMap
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        // Return the total count of subarrays with the sum equal to 'goal'
        return count;
    }

}