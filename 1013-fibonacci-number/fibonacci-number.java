class Solution {

    public int fib(int n) {
        // return n <= 1 ? n : (fib(n - 1) + fib(n - 2));

        // return fibRec(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return topDown(n, dp);
        // return bottomUp(n);

        // return fibSpace(n);
    }

    // Recursive Solution
    // TC -- O(2^N) and SC -- O(N)
    public int fibRec(int n) {
        // 1. Base Case
        if (n == 1 || n == 0) return n;
        return fib(n - 1) + fib(n - 2);
    }

    // Using topDown Approach --> Recursion + Memoization
    // TC -- O(N + N) and SC -- O(N)
    public int topDown(int n, int[] dp) {
        // 1. Base Case
        if (n == 1 || n == 0) return n;
        // 2. Check if ans already exists
        if (dp[n] != -1) return dp[n];
        // 3. Store ans in dp array
        dp[n] = topDown(n - 1, dp) + topDown(n - 2, dp);
        // 4. Return dp array
        return dp[n];
    }

    // Using bottomUp Approach --> Tabulation Method [Iterative Way]
    // TC -- O(N) and SC -- O(N)
    public int bottomUp(int n) {
        // 1. Create dp array
        int[] dp = new int[n + 1];

        // 2. Base Case
        dp[0] = 0;
        if (n == 0) return dp[0];
        dp[1] = 1;
        if (n == 1) return dp[1];

        // 3.
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Space Optimization
    // TC -- O(N) and SC -- O(1)
    public int fibSpace(int n) {
        int prev2 = 0;
        int prev1 = 1;
        int curr = 0;

        if (n <= 1) return n;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            // Shifting
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}