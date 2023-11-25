class Solution {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        // Get the number of elements in the array
        int n = nums.length;

        // Initialize variables to keep track of left and right cumulative sums
        int l = 0, r = 0;

        // Calculate the initial cumulative sum for the right side of each element
        for (int i = 0; i < n; i++) {
            r += nums[i] - nums[0];
        }

        // Initialize the result array with the sum of absolute differences for the first element
        int[] res = new int[n];
        res[0] = r;

        // Iterate through the array to calculate the sum of absolute differences for each element
        for (int i = 1; i < n; i++) {
            // Update the left cumulative sum by adding the product of the difference and the current index
            l += (nums[i] - nums[i - 1]) * i;

            // Update the right cumulative sum by subtracting the product of the difference
            // and the remaining elements on the right side
            r -= (nums[i] - nums[i - 1]) * (n - i);

            // Store the sum of left and right cumulative sums in the result array
            res[i] = l + r;
        }

        // Return the array containing the sum of absolute differences for each element
        return res;
    }
}
