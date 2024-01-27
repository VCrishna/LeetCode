public class Solution {
    Integer[][] memo = new Integer[1001][1001];
    int MOD = (int) 1e9 + 7;

    public int kInversePairs(int n, int k) {
        if (n == 0)
            return 0;
        if (k == 0)
            return 1;
        if (memo[n][k] != null)
            return memo[n][k];
        int inv = 0;
        for (int i = 0; i <= Math.min(k, n - 1); i++){
            inv = (inv + kInversePairs(n - 1, k - i)) % MOD;
        }
        memo[n][k] = inv;
        return inv;
    }
}