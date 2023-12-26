class Solution {

    // Time Complexity: O(n) - Linear time complexity, where n is the length of the input array
    // Space Complexity: O(1) - Constant space complexity, as only a constant amount of extra space is used
    public int trap(int[] height) {
        // Initialize two pointers, 'left' at the beginning, and 'right' at the end of the array
        int left = 0;
        int right = height.length - 1;

        // Initialize leftMax and rightMax to the heights at the respective pointers
        int leftMax = height[left];
        int rightMax = height[right];

        // Initialize the variable to store the result (total trapped water)
        int result = 0;

        // Check if the input array is empty or null
        if (height == null || height.length == 0) {
            return result;
        }

        // Iterate until the 'left' pointer is less than the 'right' pointer
        while (left < right) {
            // If the leftMax is less than the rightMax, process the left side
            if (height[left] < height[right]) {
                // Updating leftMax to be the maximum of its current value and the height at the 'left' pointer
                leftMax = Math.max(leftMax, height[left]);
                // Calculating and adding trapped water on the left side by subtracting the current height from the updated leftMax
                result += leftMax - height[left];
                // Moving the 'left' pointer to the right
                left++;
            } else {
                // If the rightMax is greater than or equal to the leftMax, process the right side
                // Updating rightMax to be the maximum of its current value and the height at the 'right' pointer
                rightMax = Math.max(rightMax, height[right]);
                // Calculating and adding trapped water on the right side by subtracting the current height from the updated rightMax
                result += rightMax - height[right];
                // Move the 'right' pointer to the left
                right--;
            }
        }

        // Return the total trapped water
        return result;
    }

    // Time Complexity: O(n) - Linear time complexity, where n is the length of the input array
    // Space Complexity: O(n) - Linear space complexity, used for the leftMax and rightMax arrays
    public int trap_EXTRA_SPACE(int[] height) {
        int trap = 0;

        // leftMax holds the maximum element encountered so far until that element when iterating from left to right
        int[] leftMax = new int[height.length];
        leftMax[0] = 0;

        // rightMax holds the maximum element encountered so far until that element when iterating from right to left
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = 0;

        // Populating leftMax array with maximum elements encountered while iterating from left to right
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
        }

        // Populating rightMax array with maximum elements encountered while iterating from right to left
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
        }

        // Calculating the trapped water by taking the minimum value in leftMax and rightMax
        // Subtracting it from the height at that index, and if the result is positive, adding it to the trap
        for (int i = 0; i < height.length; i++) {
            int sum = Math.min(leftMax[i], rightMax[i]) - height[i];
            trap += sum > 0 ? sum : 0;
        }

        // Returning the total trapped water
        return trap;
    }
}
/**

class Solution {
    public int trap(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            if (height[start] <= height[end]) {
                int current = height[start];
                while (height[++start] < current) {
                    result += current - height[start];
                }
            } else {
                int current = height[end];
                while(height[--end] < current) {
                    result += current - height[end];
                }
            }
        }
        return result;
    }
}
 */
