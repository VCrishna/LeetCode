class Solution {

    public int minOperations(int[] nums, int x) {
        int arrayLength = nums.length; // Number of elements in the array
        int totalSum = 0;
        for (int i : nums) 
            totalSum += i;
        int target = totalSum - x; // Calculate the target sum difference
        if (totalSum - target < 0 || totalSum < x) {
            return -1; // Return -1 if target sum is not achievable
        }
        if (target == 0) {
            return arrayLength; // Return the number of elements if target sum is 0
        }

        int minOperations = Integer.MAX_VALUE; // Minimum operations to achieve the target sum 
        int currentSum = 0; // Current sum of elements
        int leftIndex = 0, rightIndex = 0; // Pointers for the sliding window

        while (rightIndex < arrayLength) {
            currentSum += nums[rightIndex];
            rightIndex++;
            while (currentSum > target && leftIndex < arrayLength) {
                currentSum -= nums[leftIndex];
                leftIndex++;
            }
            if (currentSum == target) {
                minOperations = Math.min(minOperations, arrayLength - (rightIndex - leftIndex));
            }
        }

        return minOperations == Integer.MAX_VALUE ? -1 : minOperations;
    }
}
