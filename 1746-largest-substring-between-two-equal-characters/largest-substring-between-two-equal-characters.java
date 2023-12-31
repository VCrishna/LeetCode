class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;

        for(int left = 0; left < s.length(); left++) {
            for(int right = s.length() - 1; right >= 0; right--) {
                if(s.charAt(left) == s.charAt(right)) {
                    maxLength = Math.max(maxLength, right - left - 1);
                }
            }
        }

        return maxLength;
    }
}