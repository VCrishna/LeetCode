class Solution {
    public int firstUniqChar(String s) {
        int countArray[] = new int[26];
        for (char c : s.toCharArray()) {
            countArray[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (countArray[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}