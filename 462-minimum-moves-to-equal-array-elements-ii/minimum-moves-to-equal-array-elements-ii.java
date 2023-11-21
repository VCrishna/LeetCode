class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int steps = 0;
        int i = 0;
        int j = nums.length - 1;
        while(i < j) {
            steps += (nums[j] - nums[i]);
            i++;
            j--;
        }
        return steps;
    }
}