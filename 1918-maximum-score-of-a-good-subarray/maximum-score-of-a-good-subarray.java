class Solution {
    public int maximumScore(int[] nums, int k) {
        // Initialize two pointers, left and right, both pointing to the index k.
        int left = k, right = k;

        // Initialize the result with the value at index k.
        // This is the initial score when considering only the single element at index k.
        int result = nums[k];

        // Set the initial minimum to the value at index k.
        // This keeps track of the minimum value in the current subarray.
        int current_min = nums[k];

        // Continue the loop as long as there's room to expand the subarray to the left or right.
        while (left > 0 || right < nums.length - 1) {
            // If the left pointer is already at the start of the array,
            // we can only expand the subarray to the right.
            if (left == 0) {
                right++;
            }
            // If the right pointer is already at the end of the array,
            // we can only expand the subarray to the left.
            else if (right == nums.length - 1) {
                left--;
            }
            // If the value to the left is greater than the value to the right,
            // expand the subarray to the left to include the larger value.
            else if (nums[left - 1] > nums[right + 1]) {
                left--;
            }
            // Otherwise, expand the subarray to the right.
            else {
                right++;
            }

            // Update the current minimum. It's either the previous current_min
            // or the newly added number (either from the left or right).
            current_min = Math.min(current_min, Math.min(nums[left], nums[right]));

            // Calculate the score for the current subarray and update the result if it's greater.
            // The score is the current minimum value times the length of the subarray.
            result = Math.max(result, current_min * (right - left + 1));
        }

        // Return the maximum score.
        return result;
    }
}
