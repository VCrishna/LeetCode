class Solution {
    public int minimumLength(String s) {
        int[] charFreq = new int[26];
        int result = 0;
        for (char ch : s.toCharArray()) {
            charFreq[ch - 'a']++;
        }
        for (int i : charFreq) {
            while (i >= 3) {
                i -= 2;
            }
            result += i;
        }

        return result;
    }
}