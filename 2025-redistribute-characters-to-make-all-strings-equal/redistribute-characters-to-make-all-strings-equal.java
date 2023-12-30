class Solution {
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];
        for (String s : words) {
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
        }
        for (int i : count) {
            if (i % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}