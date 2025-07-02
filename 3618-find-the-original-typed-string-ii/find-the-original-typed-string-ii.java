class Solution {
    static final long MOD = 1_000_000_000 + 7;

    public int possibleStringCount(String word, int k) {
        int len = word.length();
        if (len == k)
            return 1; // Edge case: only the original word is possible

        // Step 1: Group consecutive characters into blocks
        List<Integer> block = new ArrayList<>();
        int i = 0;

        while (i < len) {
            int j = i + 1;
            while (j < len && word.charAt(j) == word.charAt(j - 1))
                j++;
            block.add(j - i); // Store the length of this repeated group
            i = j;
        }

        int cnt = block.size(); // Number of character blocks (i.e., decisions to make)

        // Step 2: Compute total possible combinations = product of all block lengths
        // mult[i] = product of block[i] * block[i+1] * ... * block[n-1]
        long[] mult = new long[cnt];
        mult[cnt - 1] = block.get(cnt - 1);
        for (i = cnt - 2; i >= 0; i--) {
            mult[i] = (mult[i + 1] * block.get(i)) % MOD;
        }

        if (cnt >= k)
            return (int) mult[0];
        // If just picking 1 char from each group already reaches >= k, all full combinations are valid

        // Step 3: Initialize DP table
        // dp[i][j] = number of valid combinations starting from block i using j extra characters (beyond 1 per block)
        long[][] dp = new long[cnt][k - cnt + 1];

        // Base case: Only the last block is left
        for (i = 0; i < k - cnt + 1; i++) {
            // We can take up to block.get(cnt-1) characters from this block
            // If taking (i + 1) chars would overshoot final string length, skip
            if (block.get(cnt - 1) + i + cnt > k) {
                // Only consider valid options that would lead to final length ≤ k
                dp[cnt - 1][i] = block.get(cnt - 1) - (k - cnt - i);
            }
        }

        // Step 4: Bottom-up DP to fill the table from right to left
        for (i = cnt - 2; i >= 0; i--) {
            long sum = (dp[i + 1][k - cnt] * block.get(i)) % MOD;

            for (int j = k - cnt; j >= 0; j--) {
                // Add new option from dp[i + 1][j]
                sum = (sum + dp[i + 1][j]) % MOD;

                // Subtract out-of-bounds values to limit number of characters taken
                if (j + block.get(i) > k - cnt) {
                    // Exceeds max extra chars allowed
                    sum = (sum - dp[i + 1][k - cnt] + MOD) % MOD;
                } else {
                    // Exclude invalid additions beyond group size
                    sum = (sum - dp[i + 1][j + block.get(i)] + MOD) % MOD;
                }

                // Store the computed sum for dp[i][j]
                dp[i][j] = sum;
            }
        }

        // Final answer: number of combinations starting from block 0 using 0 extra characters
        return (int) dp[0][0];
    }
}
