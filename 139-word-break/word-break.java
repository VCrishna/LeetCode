class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int sLength = s.length();
        boolean[] memo = new boolean[sLength + 1];
        memo[sLength] = true;

        for (int i = sLength - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int wordLen = word.length();
                // Check if the current substring equals the word
                if (i + wordLen <= sLength && s.substring(i, i + wordLen).equals(word)) {
                    memo[i] = memo[i + wordLen];
                }
                // Break the inner loop if memo[i] is already true
                if (memo[i]) {
                    break;
                }
            }
        }
        return memo[0];
    }
}
