class Solution {
    public boolean isPowerOfThree(int n) {
        // Step 1: Edge case: powers of 3 are positive
        if (n != 0) { 
            // Step 2: Keep dividing by 3 while divisible
            while (n % 3 == 0) {
                n = n / 3;
            }
            // Step 3: If we ended up with 1, it's a power of 3
            return n == 1 ? true : false;
        }
        // Step 4: If n is 0, return false
        return false;
    }
}
