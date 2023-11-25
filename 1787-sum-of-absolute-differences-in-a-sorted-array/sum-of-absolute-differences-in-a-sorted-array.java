class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int totalSum = 0;
        for(int num : nums)
            totalSum += num;
        
        int[] result = new int[nums.length];
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - nums[i] - leftSum;
            result[i] = (
                i * nums[i] - leftSum + 
                rightSum - (nums.length - i - 1) * nums[i]
            );
            leftSum += nums[i];
        }
        return result;
    }
}