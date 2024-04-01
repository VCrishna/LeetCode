class Solution {
    public int lengthOfLastWord(String s) {
        // Initializing index to the last character of the string
        int lastCharIndex = s.length() - 1;
        
        // Skipping trailing spaces from the end of the string
        while (lastCharIndex >= 0 && s.charAt(lastCharIndex) == ' ') {
            lastCharIndex--;
        }
        
        // Initializing the length of the last word
        int length = 0;
        
        // Iterating backwards until we reach the beginning of the last word or the start of the string
        while (lastCharIndex >= 0 && s.charAt(lastCharIndex) != ' ') {
            // Moving the index backwards and increasing the length of the last word
            lastCharIndex--;
            length++;
        }
        
        // Returning the length of the last word
        return length;
    }
    
    public int lengthOfLastWord_STRING_METHOD(String s) {
        // Spliting the string by spaces into an array of words
        String[] sp = s.split(" ");
        
        // Returning the length of the last word in the array
        return sp[sp.length - 1].length();
    }
}
