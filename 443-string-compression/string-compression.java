class Solution {
    public int compress(char[] chars) {
        // Handling the case when the array has only one character
        if (chars.length == 1)
            return 1;
        
        // StringBuilder to build the compressed string
        StringBuilder sb = new StringBuilder();
        
        // Counter to track the consecutive occurrences of a character
        int count = 1;
        
        // Initializing a string 's' with the first character in the array
        String s = chars[0] + "";

        // Iterating through the characters in the array
        for (int i = 0; i < chars.length; i++) {
            // Checking if the current character is the same as the next one
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                count++;
            } else {
                // Appending the character and its count to the StringBuilder
                sb.append(s + (count == 1 ? "" : count + ""));

                // Updating 's' with the next character 
                // (or the current character if it's the last one)
                s = chars[(i + 1 < chars.length ? i + 1 : i)] + "";
                
                // Reset the count for the next character
                count = 1;
            }
        }
        
        // Copy the compressed characters from StringBuilder to the 
        // original array starting at index 0
        sb.getChars(0, sb.length(), chars, 0);

        // Return the length of the compressed array
        return sb.length();
    }
}
