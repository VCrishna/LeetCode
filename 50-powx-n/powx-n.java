class Solution {
    // Method to calculate x raised to the power of n
    public double myPow(double x, int n) {
        double power = power(x, n);
        // Return the result; if n is negative, return the reciprocal of power
        return n < 0 ? 1.0 / power : power;
    }

    // Recursive method to calculate x raised to the power of n
    public double power(double x, int n) {
        // Base case: if x is 0, return 0
        if (x == 0)
            return 0;
        // Base case: if n is 0, return 1
        if (n == 0)
            return 1;

        double result = 1.0;

        // Recursively calculate the power using divide and conquer technique
        result = power(x, n / 2);
        // Square the result
        result *= result;
        // If n is odd, multiply the result by x
        return n % 2 == 0 ? result : x * result;
    }
}
