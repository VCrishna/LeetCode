class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int[] result = new int[nums.length];
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // Calculate the right cumulative sum by 
            // subtracting the current element and left cumulative sum
            int rightSum = totalSum - nums[i] - leftSum;

            // Calculate the sum of absolute differences for the current element
            result[i] = (
                i * nums[i] - leftSum + 
                rightSum - (nums.length - i - 1) * nums[i]
            );

            // Update the left cumulative sum by adding the current element
            leftSum += nums[i];
        }
        return result;
    }
}
