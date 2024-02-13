class Solution {
    private static final int MOD = 1_000_000_000 + 7;

    public int countPalindromes(String s) {
        int n = s.length();
        long totalCount = 0;

        // Iterate over all possible combinations of two characters ('a' and 'b' in this
        // case)
        for (char a = '0'; a <= '9'; a++) {
            for (char b = '0'; b <= '9'; b++) {

                // Array to store the number of combinations of "ab." up to each index
                // (inclusive)
                long[] startCount = new long[n];

                // Number of combinations of "ab"
                long aBeforeB = 0;

                // Number of occurrences of character 'a'
                long aCount = 0;

                // Scan forwards to populate startCount
                for (int i = 0; i < n; i++) {
                    startCount[i] = aBeforeB;

                    // Update the counts based on the current character in the string
                    char ch = s.charAt(i);
                    if (ch == b) {
                        aBeforeB += aCount; // Increase the count of "ab"
                    }
                    if (ch == a) {
                        aCount++; // Increase the count of 'a'
                    }
                }

                // Reset counts
                aBeforeB = 0;
                aCount = 0;

                // Scan backwards to update totalCount
                for (int i = n - 1; i >= 3; i--) {
                    char ch = s.charAt(i);

                    // Update the counts based on the current character in the string
                    if (ch == b) {
                        aBeforeB += aCount; // Increase the count of "ab"
                    }
                    if (ch == a) {
                        aCount++; // Increase the count of 'a'
                    }

                    // Update totalCount with the number of combinations of "ba" encountered so far
                    // multiplied by the number of combinations of "ab." up to index i - 1
                    totalCount = (totalCount + aBeforeB * startCount[i - 1]) % MOD;
                }
            }
        }

        // Return the total count of palindromic subsequences modulo MOD
        return (int) totalCount;
    }
}
