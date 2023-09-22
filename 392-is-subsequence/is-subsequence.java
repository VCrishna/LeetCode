class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length())
            return false;

        int sLength = 0, tLength = 0;

        while(sLength < s.length() && tLength < t.length()) {
            if(s.charAt(sLength) == t.charAt(tLength)) 
                sLength++;
            tLength++;
        }
        return sLength == s.length();
    }
}