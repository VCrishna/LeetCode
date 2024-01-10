class Solution {
    public int jump(int[] nums) {
        int result = 0;
        int left = 0;
        int right = 0;
        // Contining until the right boundary reaches the last index
        while (right < nums.length - 1) {
            int farthest = 0;

            // Iterate through the current jump range to find the farthest reachable index
            for (int i = left; i < right + 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            left = right + 1; // Move the left boundary to the right boundary of the current jump
            right = farthest; // Update the right boundary with the farthest reachable index
            result++; // Increment the result (number of jumps)
        }
        return result;
    }
}