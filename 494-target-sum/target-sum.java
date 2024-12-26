public class Solution {

    int totalWays = 0;

    public int findTargetSumWays(int[] nums, int target) {
        calculateWays(nums, 0, 0, target);
        return totalWays;
    }

    private void calculateWays(
            int[] nums,
            int currentIndex,
            int currentSum,
            int target) {
        if (currentIndex == nums.length) {
            if (currentSum == target) {
                totalWays++;
            }
        } else {
            calculateWays(
                    nums,
                    currentIndex + 1,
                    currentSum + nums[currentIndex],
                    target);
            calculateWays(
                    nums,
                    currentIndex + 1,
                    currentSum - nums[currentIndex],
                    target);
        }
    }
}