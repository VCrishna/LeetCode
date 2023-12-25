class Solution {

    // Time Complexity: O(n) - Linear time complexity, where n is the length of the input array
    // Space Complexity: O(n) - Linear space complexity, used for the leftMax and rightMax arrays
    public int trap(int[] height) {
        int trap = 0;

        // leftMax holds the maximum element encountered so far until that element when iterating from left to right
        int[] leftMax = new int[height.length];
        leftMax[0] = 0;

        // rightMax holds the maximum element encountered so far until that element when iterating from right to left
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = 0;

        // Populating leftMax array with maximum elements encountered while iterating from left to right
        for (int i = 1; i <= height.length - 1; i++) {
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
