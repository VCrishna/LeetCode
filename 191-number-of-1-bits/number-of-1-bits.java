public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight_BRUTE_FORCE(int n) {
        return Integer.bitCount(n);
    }
    public int hammingWeight(int n) {
        // return Integer.bitCount(n);
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((n & mask) != 0) {
                count++;
            }
        }
        return count;
    }
}