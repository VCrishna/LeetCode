class Solution {
    public int maxFrequency(int[] nums, int k) {
        // Sort the array in ascending order
        Arrays.sort(nums);
        
        // Initialize pointers, result, and total
        int left = 0;
        int right = 0;
        int result = 0;
        long total = 0;

        // Loop through the array using the right pointer
        while (right < nums.length) {
            // Add the current element to the total sum
            total += nums[right];

            // Check if the current frequency can be increased within the given k operations
            while (nums[right] * (right - left + 1) > total + k) {
                // If not, subtract the leftmost element from the total and move the left pointer
                total -= nums[left++];
            }

            // Update the result with the maximum frequency so far
            result = Math.max(result, right - left + 1);

            // Move the right pointer to the next element
            right++;
        }

        // Return the final result
        return result;
    }
}
