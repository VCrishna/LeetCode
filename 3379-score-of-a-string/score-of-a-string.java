class Solution {
    public int scoreOfString(String s) {
        int result = 0;

        for (int i = 0; i + 1 < s.length(); i++) {
            result += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }

        return result;
    }
}