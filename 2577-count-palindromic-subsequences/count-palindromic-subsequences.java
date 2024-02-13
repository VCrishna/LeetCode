class Solution {
    private static final int MOD = (int) 1e9 + 7;

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

    public int countPalindromes_DIFF(String s) {
        Integer[][][][] memo = new Integer[s.length()][10][10][5];
        // index can be till string length, 10 digits so use 10 in for first and second
        // character and 5 is only allowed length.
        return solve(s, 0, 0, 0, 0, memo);
    }

    int solve(String s, int index, int first, int second, int length, Integer[][][][] memo) {
        if (length == 5) {
            return 1;// palindrome achived count it
        }
        if (index == s.length()) {
            return 0;// not possible to achive palindrome
        }
        if (memo[index][first][second][length] != null) {
            return memo[index][first][second][length];
        }
        int value = s.charAt(index) - '0';

        int include = 0;
        if (length == 0) {
            include = solve(s, index + 1, value, second, length + 1, memo);// will be matched with 5th char
        } else if (length == 1) {
            include = solve(s, index + 1, first, value, length + 1, memo);// will be matched with 4th char
        } else if (length == 2) {
            include = solve(s, index + 1, first, second, length + 1, memo);// middle char of 5 letter palindrom, does
                                                                           // not need matching
        } else if (length == 3 && value == second) {// check if same as second char
            include = solve(s, index + 1, first, second, length + 1, memo);
        } else if (length == 4 && value == first) {// check if same as first char
            include = solve(s, index + 1, first, value, length + 1, memo);
        }

        // ignore the current char and move to next char like we do not subsequences
        // matching
        int exclude = solve(s, index + 1, first, second, length, memo);

        int answer = (include % MOD) + (exclude % MOD);// add both results
        return memo[index][first][second][length] = answer % MOD;
    }
}
