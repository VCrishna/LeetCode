class Solution {

    // Efficient solution using sorting
    public int minMoves2(int[] nums) {
        Arrays.sort(nums); // Sort the array in ascending order
        int steps = 0; // Counter for the minimum moves
        int i = 0; // Start index
        int j = nums.length - 1; // End index

        // Iterate until the two pointers meet in the middle
        while (i < j) {
            steps += (nums[j] - nums[i]); // Add the difference between the larger and smaller elements
            i++; // Move the start pointer towards the center
            j--; // Move the end pointer towards the center
        }

        return steps; // Return the total minimum moves
    }

    // Brute-force solution without sorting
    public int minMoves2_BRUTE_FORCE(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array in ascending order
        int steps = 0; // Counter for the minimum moves

        // Calculate the median (middle element) of the sorted array
        int median = (n % 2 == 0 ? (nums[n / 2] + nums[n / 2 - 1]) / 2 : nums[n / 2]);

        // Iterate through the array and add the absolute differences between each element and the median
        for (int i : nums) {
            steps += Math.abs(i - median);
        }

        return steps; // Return the total minimum moves
    }
}
