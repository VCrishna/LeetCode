class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];

        int totalSum = 0;
        for (int num : nums) totalSum += num;
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - nums[i] - leftSum;

            result[i] = (
                nums[i] * i - leftSum + rightSum - (nums.length - i - 1) * nums[i]
            );
            leftSum += nums[i];
        }

        return result;
    }
    public int[] getSumAbsoluteDifferences_BRUTE_FORCE(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                result[i] += Math.abs(nums[i]-nums[j]);
            }
        }

        return result;
    }
}
