class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        // dp[t] = number of people who **learned the secret exactly at day t**
        long[] dp = new long[n + 1];

        // Day 1: exactly one person knows the secret initially
        dp[1] = 1;

        long share = 0;                  // Number of people who can share the secret today
        long MOD = (long)1e9 + 7;        // To avoid overflow

        // Iterate over each day
        for (int t = 2; t <= n; t++) {
            // Step 1: Add new people who become able to share the secret today
            // People who learned the secret 'delay' days ago can start sharing now
            if (t - delay > 0)
                share = (share + dp[t - delay] + MOD) % MOD;

            // Step 2: Remove people who forgot the secret
            // People who learned the secret 'forget' days ago forget it today
            if (t - forget > 0)
                share = (share - dp[t - forget] + MOD) % MOD;

            // Step 3: Number of people learning the secret today
            dp[t] = share;
        }

        // Step 4: Sum people who still know the secret on the last day
        // People who learned the secret within the last 'forget' days
        long know = 0;
        for (int i = n - forget + 1; i <= n; i++)
            know = (know + dp[i]) % MOD;

        return (int)know;
    }
}
