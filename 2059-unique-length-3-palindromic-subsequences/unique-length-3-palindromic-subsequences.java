public class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> res = new HashSet<>();
        Set<Character> left = new HashSet<>();
        int[] right = new int[26];

        for (char c : s.toCharArray()) {
            right[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            right[s.charAt(i) - 'a']--;
            if (right[s.charAt(i) - 'a'] == 0) {
                right[s.charAt(i) - 'a'] = -1;
            }

            for (int j = 0; j < 26; j++) {
                char c = (char) (j + 'a');
                if (left.contains(c) && right[j] > 0) {
                    res.add("" + s.charAt(i) + c);
                }
            }
            left.add(s.charAt(i));
        }

        return res.size();
    }
}