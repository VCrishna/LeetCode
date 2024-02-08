class Solution {
    public int countBinarySubstrings(String s) {
        // Initializing the result variable to store the count of valid substrings
        int result = 0;
        
        // Array to store counts of consecutive characters (groups)
        int[] charCountGroup = new int[s.length()];
        
        // Initializing the count for the first character group
        charCountGroup[0] = 1;
        
        // Index to keep track of the current character group
        int index = 0;
        
        // Iterating through the string to count consecutive character groups
        for (int i = 1; i < s.length(); i++) {
            // If the current character is different from the previous one
            if (s.charAt(i) != s.charAt(i - 1)) {
                // Starting a new character group and initialize its count to 1
                charCountGroup[++index] = 1;
            } else {
                // Incrementing the count of the current character group
                charCountGroup[index]++;
            }
        }
        
        // Iterating through each pair of adjacent character groups
        for (int i = 1; i <= index; i++) {
            // Counting the number of valid substrings between two adjacent groups
            // by taking the minimum count of consecutive characters in each group
            result += Math.min(charCountGroup[i], charCountGroup[i - 1]);
        }

        // Returning the total count of valid substrings
        return result;
    }
}