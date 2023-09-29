class Solution {

    public String decodeAtIndex(String s, int k) {
        long decodedStringLength = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) decodedStringLength *= c - '0'; else decodedStringLength++;
        }
        // System.out.println(decodedStringLength);
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            k %= decodedStringLength;

            if (k == 0 && Character.isLetter(ch)) {
                return Character.toString(ch);
            }
            if(Character.isDigit(ch)) {
                decodedStringLength /= ch - '0';
            }
            else {
                decodedStringLength--;
            }
        }
        return null;
    }
}
