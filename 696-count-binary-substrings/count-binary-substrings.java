class Solution {
    public int countBinarySubstrings(String s) {
        int result = 0;
        int[] charCountGroup = new int[s.length()];
        charCountGroup[0] = 1;
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                charCountGroup[++index] = 1;
            } else {
                charCountGroup[index]++;
            }
        }
        for (int i = 1; i <= index; i++) {
            result += Math.min(charCountGroup[i], charCountGroup[i - 1]);
        }

        return result;
    }
}