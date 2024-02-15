class Solution {
    public long largestPerimeter(int[] nums) {
        // Sort the input array
        Arrays.sort(nums);

        long previousElementsSum = 0; // Sum of previously iterated elements
        long ans = -1; // Variable to store the largest perimeter found

        for (int num : nums) {
            // Check if the current number can form a polygon with the previous elements
            if (num < previousElementsSum) {
                // Update the answer with the sum of current number and previousElementsSum
                ans = num + previousElementsSum;
            }
            // Update previousElementsSum with the current number
            previousElementsSum += num;
        }
        return ans;
    }
}
