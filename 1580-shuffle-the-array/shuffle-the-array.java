class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int index = 0;
        int e = 0;
        int o = n;
        while (index < nums.length) {
            result[index++] = nums[e++];
            result[index++] = nums[o++];
        }
        return result;
    }
}
