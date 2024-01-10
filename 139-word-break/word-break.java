class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int sLength = s.length();
        boolean[] dp = new boolean[sLength + 1];
        dp[sLength] = true;

        for(int i = sLength - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int wordLength = word.length();
                if(
                    i + wordLength <= sLength && s.substring(i, i + wordLength).equals(word)
                ) {
                    dp[i] = dp[i + wordLength];
                }
                if(dp[i]) {
                    break;
                }
            }
        }


        return dp[0];
    }
}