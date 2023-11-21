class Solution {
    // 0 <= i < j < nums.length
    // nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
    // nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
    public int countNicePairs(int[] nums) {
        int MOD = (int) 1e9 + 7; // Modulo constant for handling potential overflow
        int result = 0; // Counter for nice pairs
        Map<Integer, Integer> map = new HashMap<>(); // Map to store differences and their frequencies

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the difference between nums[i] and its reverse
            int difference = nums[i] - rev(nums[i]);

            // Check if the current difference is already in the map
            if (map.containsKey(difference)) {
                // Update result by adding the frequency of the difference
                result = (result + map.get(difference)) % MOD;
            }

            // Update the frequency of the current difference in the map
            map.put(difference, map.getOrDefault(difference, 0) + 1);
        }

        // Return the final result modulo MOD
        return result % MOD;
    }

    // Helper method to reverse the digits of a number
    public int rev(int n) {
        int reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        return reverse;
    }
}
