class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if (nums.length <= 1) return nums;
        int index = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) result[index++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) result[index++] = nums[i];
        }

        return result;
    }
}
