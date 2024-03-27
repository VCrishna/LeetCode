class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0; // Initializing the result counter
        int left = 0; // Initializing the left pointer for the sliding window
        int product = 1; // Initializing the product of elements within the sliding window

        // Iterating through the array using the right pointer
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right]; // Updating product by multiplying with the current element

            // Checking if product exceeds or equals k
            while (left <= right && product >= k) {
                product = product / nums[left]; // Adjusting product by dividing by nums[left]
                left++; // Moving the left pointer to the right to shrink the window
            }

            // At this point, all subarrays ending at the current right pointer
            // that satisfy the condition are counted.
            // The count is the difference between right and left pointers plus one
            result += (right - left + 1);
        }
        // Returning the total count of subarrays
        return result;
    }
}