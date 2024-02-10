class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            // odd length
            int left = i;
            int right = i;
            count += countPalindrome(s, left, right);
            // even length
            left = i;
            right = i + 1;
            count += countPalindrome(s, left, right);
        }
        return count;
    }
    private int countPalindrome(String s, int left, int right) {
        int paliCount = 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            paliCount++;
            left--;
            right++;
        }

        return paliCount;
    }
}
