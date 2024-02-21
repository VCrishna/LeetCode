class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        // Finding the common prefix (1-bits) in binary representation
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        // Shifting left by the common prefix
        return left << shift;
    }
}