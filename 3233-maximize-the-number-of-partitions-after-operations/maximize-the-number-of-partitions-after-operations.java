class Solution {
    private Map<Long, Integer> memo = new HashMap<>();
    private String s;
    private int k;

    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.k = k;
        memo.clear();
        return dp(0, 0L, true) + 1; // +1 for the last partition
    }

    // DP: index i, used character mask, canChange flag
    private int dp(int i, long mask, boolean canChange) {
        if (i == s.length()) return 0;

        long key = (((long) i) << 27) | (mask << 1) | (canChange ? 1 : 0);
        if (memo.containsKey(key)) return memo.get(key);

        int ch = s.charAt(i) - 'a';
        long newMask = mask | (1L << ch);
        int res;

        // Option 1: No change at this character
        if (Long.bitCount(newMask) > k) {
            // Too many distinct chars, start a new partition
            res = 1 + dp(i + 1, 1L << ch, canChange);
        } else {
            // Keep building the current partition
            res = dp(i + 1, newMask, canChange);
        }

        // Option 2: Change this character (only once allowed)
        if (canChange) {
            for (int j = 0; j < 26; j++) {
                long changeMask = mask | (1L << j);
                if (Long.bitCount(changeMask) > k) {
                    res = Math.max(res, 1 + dp(i + 1, 1L << j, false));
                } else {
                    res = Math.max(res, dp(i + 1, changeMask, false));
                }
            }
        }

        memo.put(key, res);
        return res;
    }
}
