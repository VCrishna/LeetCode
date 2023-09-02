class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int wordLength = s.length();
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        Integer[] memo = new Integer[wordLength];
        // System.out.println(dict);
        return dp(0, wordLength, s, dict, memo);
    }

    private int dp(int start, int wordLength, String s, Set<String> dict, Integer[] memo) {
        if (start == wordLength) return 0;
        if (memo[start] != null) return memo[start];

        int ans = dp(start + 1, wordLength, s, dict, memo) + 1;
        for(int end = start; end < wordLength; end++) {
            String current = s.substring(start, end + 1);
            if (dict.contains(current)) {
                ans = Math.min(ans, dp(end + 1, wordLength, s, dict, memo));
            }
        }
        return memo[start] = ans;
    }
}
