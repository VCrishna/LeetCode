class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        int[][] dpLCS = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dpLCS[i][j] = 1 + dpLCS[i - 1][j - 1];
                } else {
                    dpLCS[i][j] = Math.max(dpLCS[i - 1][j], dpLCS[i][j - 1]);
                }
            }
        }
        return dpLCS[length1][length2];
    }
}