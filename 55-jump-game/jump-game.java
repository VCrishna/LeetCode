class Solution {

    public boolean canJump(int[] nums) {
        // Initialize the goal as the last index of the array
        int goal = nums.length - 1;

        // Iterate backward through the array starting 
        // from the second-to-last index
        for (int i = nums.length - 2; i >= 0; i--) {
            // Check if the current index plus its value 
            // can reach the current goal
            if (nums[i] + i >= goal) {
                // If it can, update the goal to the current index
                goal = i;
            }
        }

        // Check if the goal is at the start of the array (index 0)
        return goal == 0;
    }
}