class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int p = nums.get(i);

            // Even numbers (including prime 2) are impossible
            if ((p & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            /*
             * Explanation:
             * p is odd.
             * (p + 1) & ~p  -> isolates the lowest zero bit in p
             * >> 1          -> gives the bit just before that
             * Clearing that bit minimizes ans while preserving:
             * ans | (ans + 1) == p
             */
            ans[i] = p & ~(((p + 1) & ~p) >> 1);
        }

        return ans;
    }
}
