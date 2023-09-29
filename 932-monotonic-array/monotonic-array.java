class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) return true;
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < nums.length - 1; i++) {
            // checking if elements side by side or in increasing or decreasing in order
            // if they are decreasing, then increasing is false
            if (nums[i] > nums[i+1]) 
                increasing = false;
            // if they are increasing, then decreasing is false
            if (nums[i] < nums[i+1]) 
                decreasing = false;
        }
        // if (!increasing && !decreasing) {
        //     return false;
        // }
        return increasing || decreasing;
    }
}
