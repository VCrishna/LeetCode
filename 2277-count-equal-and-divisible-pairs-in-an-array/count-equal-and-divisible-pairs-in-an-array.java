class Solution {
    public int countPairs(int[] nums, int k) {
        return helper(nums, k, 0); // Step 1: Start from index 0
    }

    private static int helper(int[] nums, int k, int i) {
        // Step 6: Base case — when i reaches end
        if (i >= nums.length) {
            return 0;
        }

        int count = 0;

        // Step 2: Iterate j from i+1 to end
        for (int j = i + 1; j < nums.length; j++) {
            // Step 3: Check if values match and divisible condition
            if (nums[i] == nums[j] && (i * j) % k == 0) {
                count++; // Step 4: Valid pair found
            }
        }

        // Step 5: Move to next index i+1 recursively
        return count + helper(nums, k, i + 1);
    }
}