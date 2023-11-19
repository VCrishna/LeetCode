class Solution {

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int distinctCount = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1])
                distinctCount++;

            result += distinctCount;
        }

        return result;
    }
    public int reductionOperations_BRUTE_FORCE(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i] < nums[i + 1]) {
                result += nums.length - 1 - i;
            }
        }
        return result;
    }
}
