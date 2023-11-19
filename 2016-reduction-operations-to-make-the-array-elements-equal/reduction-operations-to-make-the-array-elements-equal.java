class Solution {

    public int reductionOperations(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i] < nums[i + 1]) {
                // while (nums[i] < nums[i + 1]) {
                //     nums[i + 1]--;
                // }
                // result++;
                result += nums.length - 1 - i;
            }
            // i = nums.length - 2;
        }
        return result;
    }
}
