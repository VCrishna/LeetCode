class Solution {
    public int countCompleteSubarrays(int[] nums) {
        // Step 1: Calculate total number of unique elements in the entire array.
        int totalDistinct = getDistinctCount(nums);
        // Step 2: Use the formula:
        // Number of subarrays with exactly `k` distinct elements =
        // Subarrays with at most `k` distinct elements
        //   - Subarrays with at most `k - 1` distinct elements
        return atMostKDistinct(nums, totalDistinct) - atMostKDistinct(nums, totalDistinct - 1);
    }

    // Helper method to find the total number of distinct elements in the array
    private int getDistinctCount(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); // Set automatically handles duplicates
        }
        return set.size(); // Returns number of distinct elements
    }

    // Helper method to count subarrays with at most k distinct elements
    private int atMostKDistinct(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0;
        int count = 0;

        // Slide the window
        while (right < nums.length) {
            // Add the current element to the frequency map
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            // If we exceed `k` distinct elements, shrink the window from the left
            while (freqMap.size() > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]); // Remove element with zero count
                }
                left++; // Move the window forward
            }

            // For the current window [left, right], there are (right - left + 1)
            // valid subarrays ending at `right` that satisfy the "at most k distinct" condition
            count += right - left + 1;

            right++; // Move the window to the right
        }

        return count;
    }

    public int countCompleteSubarrays_BRUTE_FORCE(int[] nums) {
        int result = 0;
        // Step 1: Get the count of distinct elements in the full array
        Set<Integer> distinctElements1 = new HashSet<>();
        for (int i : nums) {
            distinctElements1.add(i);
        }
        // Now distinctElements1.size() gives us the number of distinct elements in nums
        // Step 2: Loop through all possible subarrays
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> distinctElements2 = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                distinctElements2.add(nums[j]);
                // Step 3: If subarray has all the distinct elements (like the full array), it's a "complete" subarray
                if (distinctElements1.size() == distinctElements2.size()) {
                    // Every subarray starting from i and ending at or after j will also be complete
                    result += nums.length - j;
                    break; // No need to check longer subarrays starting from i
                }
            }
        }
        return result;
    }
}
