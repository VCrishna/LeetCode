class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLength = expand(i, i, s);
            // if (oddLength > end - start + 1) {
            //     int dist = oddLength / 2;
            //     start = i - dist;
            //     end = i + dist;
            // }
            
            int evenLength = expand(i, i + 1, s);
            // if (evenLength > end - start + 1) {
            //     int dist = (evenLength / 2) - 1;
            //     start = i - dist;
            //     end = i + 1 + dist;
            // }
            int len = Math.max(evenLength, oddLength);
            if(len > end - start){
                start = i - ((len - 1)/2);
                end = i + (len/2);
            }
        }

        return s.substring(start, end + 1);
    }
    
    private int expand(int left, int right, String s) {  
        if(s == null || left > right) return 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}