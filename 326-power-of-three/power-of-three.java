class Solution {
    public boolean isPowerOfThree(int n) {
        if (n != 0) {
            while (n % 3 == 0) {
                n = n / 3;
            }
            return n == 1 ? true : false;
        }
        return false;
    }
}