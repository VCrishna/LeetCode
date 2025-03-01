class Solution {
    public int[] applyOperations(int[] nums) {

        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                if (nums[i] == nums[i + 1]) {
                    nums[i] = nums[i] * 2;
                    nums[i + 1] = 0;
                } else {
                    continue;
                }
            }
        }
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                ret[count++] = nums[j];
            }
        }
        while (count < nums.length) {
            ret[count++] = 0;
        }
        return ret;

    }
}