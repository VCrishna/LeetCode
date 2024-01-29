class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // Getting the lengths of the input texts
        int length1 = text1.length();
        int length2 = text2.length();

        // Creating a 2D array to store the length of LCS for each pair of substrings
        int[][] dpLCS = new int[length1 + 1][length2 + 1];

        // Iterate through each character of both texts
        // Fill the dp array using dynamic programming
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                // If the current characters match
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Increment the length of LCS by 1 and take the value from the diagonal
                    // Characters match, extend the common subsequence
                    dpLCS[i][j] = 1 + dpLCS[i - 1][j - 1];
                } else {
                    // If characters don't match, take the maximum of the LCS without
                    // one character either from text1 (move up) or from text2 (move left)
                    // choosing the maximum length from the previous subproblems
                    dpLCS[i][j] = Math.max(dpLCS[i - 1][j], dpLCS[i][j - 1]);
                }
            }
        }
        return dpLCS[length1][length2];
    }
}
