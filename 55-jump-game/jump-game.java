class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int currentIndex = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentIndex < i) {
                return false; // Unable to reach the current position
            }
            currentIndex = Math.max(currentIndex, i + nums[i]);
            
            if (currentIndex >= nums.length - 1) {
                return true; // Reached or surpassed the last index
            }
        }

        return true;
    }
}