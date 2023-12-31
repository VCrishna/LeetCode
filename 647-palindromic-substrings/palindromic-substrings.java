class Solution {

    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd length palindrome
            int left = i;
            int right = i;
            count += countPalindromes(s, left, right);

            // even length palindrome
            left = i;
            right = i + 1;
            count += countPalindromes(s, left, right);
        }
        return count;
    }

    public int countPalindromes(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
