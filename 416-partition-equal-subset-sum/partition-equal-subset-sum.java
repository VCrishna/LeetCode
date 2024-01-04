class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i : nums) {
            totalSum += i;
        }
        if(totalSum % 2 != 0) {
            return false;
        }

        return canPartition(nums, 0, 0, totalSum, new HashMap<String, Boolean>());
    }

    public boolean canPartition(
        int[] nums,
        int index,
        int currentSum,
        int target,
        Map<String, Boolean> state
    ) {
        String currentState = index + " , " + currentSum;
        
        if(state.containsKey(currentState)) {
            return state.get(currentState);
        }

        if(currentSum * 2 == target) {
            return true;
        }
        if(currentSum > target / 2 || index >= nums.length) {
            return false;
        }
        

        boolean foundPartition = 
        // considering current element
        canPartition(nums, index + 1, currentSum + nums[index], target, state) ||
        // not considering current element
        canPartition(nums, index + 1, currentSum, target, state);
        state.put(currentState, foundPartition);
        return foundPartition;
    }
}