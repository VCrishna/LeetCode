class Solution {
    private int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, wordDict, s.length()-1);

    }
    public boolean dp(String s, List<String> wordDict, int i) {
        if(i < 0)
            return true;
        if(memo[i] != -1)
            return memo[i] == 1;
        for(String word : wordDict) {
            if (i - word.length() + 1 < 0) {
                continue;
            }
            if (s.substring(i - word.length() + 1, i + 1).equals(word) && 
                dp(s, wordDict, i - word.length())) {
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }
}