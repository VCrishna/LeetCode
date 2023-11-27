class Solution {
    public int knightDialer(int n) {
        if (n == 1)
            return 10;
        int MOD = (int)1e9 + 7;
        int result = 0;
        int[][] jumps = {
                {4, 6},
                {6, 8},
                {7, 9},
                {4, 8},
                {3, 9, 0},
                {},
                {1, 7, 0},
                {2, 6},
                {1, 3},
                {2, 4}
        };
        int[] dp = new int[10];
        for (int i = 0; i < 10; i++) {
            dp[i] = 1;
        }
        for (int k = 0; k < n - 1; k++) {
            int[] nextDp = new int[10];
            for (int digit = 0; digit < 10; digit++) {
                for (int jump : jumps[digit]) {
                    nextDp[jump] = (nextDp[jump] + dp[digit]) % MOD;
                }
            }
            dp = nextDp;
        }

        for (int count : dp) {
            result = (result + count) % MOD;
        }

        return result;
    }
}