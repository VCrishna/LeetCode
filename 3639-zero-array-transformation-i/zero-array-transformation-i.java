class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1]; // Difference array for range increments

        // Step 1: Build difference array from queries
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            diff[l] += 1;
            if (r + 1 < n) diff[r + 1] -= 1;
        }

        // Step 2: Convert difference array to prefix sum to get actual allowed decrements
        int[] allowed = new int[n];
        allowed[0] = diff[0];
        for (int i = 1; i < n; i++) {
            allowed[i] = allowed[i - 1] + diff[i];
        }

        // Step 3: Check if each nums[i] can be reduced to 0
        for (int i = 0; i < n; i++) {
            if (nums[i] > allowed[i]) return false;
        }

        return true;
    }
}