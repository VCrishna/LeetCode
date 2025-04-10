class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        // Convert the suffix string s into a number
        long suffix = 0L;
        for (char c : s.toCharArray())
            suffix = suffix * 10 + c - '0'; // e.g., "23" -> 23

        // If the suffix itself is larger than finish, no valid number can exist
        if (suffix > finish)
            return 0;

        // div = 10^length(s), used to separate prefix and suffix
        long div = (long) Math.pow(10, s.length());

        // ps = prefix range start (prefix of 'start' after stripping suffix digits)
        // pf = prefix range finish (prefix of 'finish' after stripping suffix digits)
        long ps = start / div, pf = finish / div;

        // Adjust pf: if finish has enough space to include 'suffix', include it
        if (finish % div >= suffix)
            pf++;

        // Adjust ps: if start has suffix greater than desired, skip it
        if (start % div > suffix)
            ps++;

        // Count how many valid prefixes (with digits <= limit) are in [ps, pf)
        return getAvailNum(pf, limit) - getAvailNum(ps, limit);
    }

    // Helper to count how many numbers < num can be formed
    // using only digits <= limit
    private long getAvailNum(long num, long limit) {
        if (num == 0)
            return 0;

        if (limit == 9)
            return num; // If all digits are allowed, all numbers < num are valid

        // Number of digits in num - 1
        int digits = (int) Math.log10(num);

        // Highest power of 10 just below num
        long div = (long) Math.pow(10, digits);

        long res = 0L;

        // Loop through each digit from most significant to least
        for (int i = digits; i >= 0; i--) {
            int d = (int) (num / div); // Current digit

            if (d > limit)
                // If digit > limit, all combinations for this digit and lower are valid
                return res + (long) Math.pow(limit + 1, i + 1);
            else
                // Add the count of valid numbers with this digit and lower positions
                res += d * (long) Math.pow(limit + 1, i);

            // Strip off the digit and move to the next
            num %= div;
            div /= 10;
        }

        return res;
    }
}
