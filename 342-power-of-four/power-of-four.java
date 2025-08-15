class Solution {
    public boolean isPowerOfFour(int n) {
        // Step 1: Edge case — powers of 4 are positive
        if (n != 0) {
            // Step 2: Keep dividing by 4 while it's divisible
            while (n % 4 == 0) {
                n = n / 4;
            }
            // Step 3: If we reduced n to 1, it was a power of 4
            return n == 1 ? true : false;
        }
        // Step 4: Zero and negative numbers return false
        return false;
    }
}
