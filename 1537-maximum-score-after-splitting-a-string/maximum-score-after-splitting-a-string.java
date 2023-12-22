class Solution {
    public int maxScore(String s) {
        int max = Integer.MIN_VALUE;
        int length = s.length();
        int ones = 0;
        int zeros = 0;
        for(char c : s.toCharArray()) {
            if(c=='1') ones++;
        }
        for(int i = 0; i < length - 1; i++) {
            if(s.charAt(i) == '0') {
                zeros++;
            }
            else if(s.charAt(i) == '1') ones--;
            max = Math.max(max, ones > 0 ? zeros + ones : zeros);
        }

        return max;
    }
}