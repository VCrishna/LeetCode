class Solution {
    public char findTheDifference(String s, String t) {
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for (char c : s.toCharArray()) {
            sArr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tArr[c - 'a']++;
        }
        char ret = 'a';
        for (char c : t.toCharArray()) {
            if (tArr[c - 'a'] > sArr[c - 'a']) return c;
        }
        return ret;
    }
}
