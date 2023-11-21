class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int steps = 0;
        int median = (n % 2 == 0 ? (nums[n / 2] + nums[n / 2 - 1]) / 2 : nums[n / 2]);
        for(int i : nums) {
            steps += Math.abs(i - median);
        }
        return steps;
    }
    public int minMoves2_better(int[] nums) {
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