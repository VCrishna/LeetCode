class Solution {
    public int findDuplicate(int[] nums) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                nums[index] *= -1;
                return index + 1;
            } else
                nums[index] *= -1;
        }
        return result;
    }
}