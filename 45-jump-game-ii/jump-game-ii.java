class Solution {
    public int jump(int[] nums) {
        int result = 0;
        int left = 0;
        int right = 0;
        // Contining until the right boundary reaches the last index
        while (right < nums.length - 1) {
            // Variable to store the farthest reachable index
            int farthest = 0;
            // Iterating through the current jump range to find the farthest reachable index
            for (int i = left; i < right + 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            // Moving the left boundary to the right boundary + 1 of the current jump
            left = right + 1;
            // Updating the right boundary with the farthest reachable index
            right = farthest;
            // Increment the result (number of jumps)
            result++;
        }
        return result;
    }
}