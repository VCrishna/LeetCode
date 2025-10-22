class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        // Edge case: only one number, frequency = 1
        if (nums.length == 1)
            return 1;

        // Sort the array so that we can easily work with numeric ranges
        Arrays.sort(nums);

        // Prepare an initial upper bound — the largest number of elements 
        // that can already fall into a valid range (difference ≤ 2*k)
        // We take min(numOperations, prepareMaxNums(...)) as a starting reference.
        int right = Math.min(numOperations, prepareMaxNums(nums, k));

        // These pointers and counters help us manage our current range window.
        int index = 0, left = 0, freq = 0;

        // Iterate through each number as a potential "center" of alignment
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            // freq counts consecutive identical numbers (duplicates)
            freq = (i > 0 && nums[i] == nums[i - 1]) ? freq + 1 : 1;

            // Define the allowable range for this number
            int min = n - k, max = n + k;

            // Expand or contract the window so that it only includes
            // numbers whose values are within [min, max].
            while (true) {
                if (index < nums.length && nums[index] < min) {
                    // Move index forward to exclude numbers too small to fit the range
                    index++;
                } else if (left < nums.length && nums[left] <= max) {
                    // Expand the window rightwards as long as values are within range
                    left++;
                } else {
                    // Stop when left hits a number outside the valid range
                    break;
                }
            }

            // Step 4️⃣: Now the range [index, left) represents all numbers 
            // that can already be aligned with nums[i] (within ±k).

            // freq + numOperations means we can potentially turn some other numbers
            // into this value using available operations, but we cannot exceed 
            // the current valid window size (left - index).
            right = Math.max(right, Math.min(freq + numOperations, left - index));
        }

        // Step 5️⃣: Return the best frequency found
        return right;
    }

    // Helper function: computes the maximum size of a continuous window 
    // where all numbers differ by at most 2*k.
    public int prepareMaxNums(int[] nums, int k) {
        int left = 0;
        int right = 0;

        // For each starting index 'i', expand 'left' as long as 
        // nums[left] <= nums[i] + 2*k (i.e., numbers are close enough to align)
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i] + 2 * k;

            while (left < nums.length && nums[left] <= target) {
                left++;
            }

            // Track the largest window size seen so far
            right = Math.max(right, left - i);
        }

        // This gives us the max number of elements that could 
        // potentially align without using operations
        return right;
    }
}