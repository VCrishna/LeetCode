class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int n : nums) {
            totalSum += n;
        }
        if(totalSum % 2 != 0) {
            return false;
        }
        // canPartition(nums, currentIndex, currentSum, totalSum, dp map)
        return canPartition(nums, 0, 0, totalSum, new HashMap<String, Boolean>());
    }

    public boolean canPartition(
        int[] nums,
        int currentIndex,
        int currentSum,
        int totalSum,
        Map<String, Boolean> state
    ) {
        String currentState = currentIndex + " , " + currentSum;
        if(state.containsKey(currentState)) {
            return state.get(currentState);
        }
        if(currentSum * 2 == totalSum) {
            return true;
        }
        if(currentSum > totalSum / 2 || currentIndex >= nums.length) {
            return false;
        }

        boolean canPatition = 
        // considering the current element
        canPartition(nums, currentIndex + 1, currentSum + nums[currentIndex], totalSum, state) ||
        // not considering the current element
        canPartition(nums, currentIndex + 1, currentSum, totalSum, state);

        state.put(currentState, canPatition);
        return canPatition;

    }
}