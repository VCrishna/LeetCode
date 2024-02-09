class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        // Define the search range, ensuring that it covers all possible integer values
        long left = 1, right = (int) (2 * 1e9);

        // Initialize the answer to the maximum possible value
        long ans = right;

        // Calculate the least common multiple (LCM) of divisor1 and divisor2
        // The LCM of two numbers is the smallest positive integer that is divisible by
        // both numbers
        // The GCD of two numbers is the largest positive integer that divides both
        // numbers without leaving a remainder
        long lcm = (1L * divisor1 * divisor2) / gcd(divisor1, divisor2);

        // Binary search loop
        while (left <= right) {
            // Calculate the middle number
            long mid = left + (right - left) / 2;

            // Calculate the count of numbers not divisible by divisor1, divisor2, and their
            // LCM up to mid
            long x = mid - (mid / divisor1);
            long y = mid - (mid / divisor2);
            long z = mid - (mid / lcm);

            // Check if the counts satisfy the conditions
            if (x < 1L * uniqueCnt1 || 
                y < 1L * uniqueCnt2 || 
                z < 1L * (uniqueCnt1 + uniqueCnt2)
                ) {
                // If not, adjust the search range to the right
                left = mid + 1;
            } else {
                // If yes, update the answer and narrow down the search range to the left
                ans = Math.min(ans, mid);
                right = mid - 1;
            }

            // Check if the counts satisfy the conditions
            if (x < 1L * uniqueCnt1 || y < 1L * uniqueCnt2 || z < 1L * (uniqueCnt1 + uniqueCnt2)) {
                // If not, adjust the search range to the right
                left = mid + 1;
            } else {
                // If yes, update the answer and narrow down the search range to the left
                ans = Math.min(ans, mid);
                right = mid - 1;
            }

            // Check if the counts satisfy the conditions
            if (x < 1L * uniqueCnt1 || y < 1L * uniqueCnt2 || z < 1L * (uniqueCnt1 + uniqueCnt2)) {
                // If not, adjust the search range to the right
                left = mid + 1;
            } else {
                // If yes, update the answer and narrow down the search range to the left
                ans = Math.min(ans, mid);
                right = mid - 1;
            }
        }

        // Return the minimum possible maximum integer found
        return (int) ans;
    }

    // Method to calculate the greatest common divisor (GCD) using the Euclidean
    // algorithm
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}