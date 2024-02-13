class Solution {
    public String removeDuplicates(String s, int k) {
        // Initialize a StringBuilder to manipulate the string efficiently
        StringBuilder sb = new StringBuilder(s);

        // Create an array count to keep track of the count of consecutive occurrences
        // of characters
        int count[] = new int[sb.length()];

        // Iterate through the characters of the string
        for (int i = 0; i < sb.length(); ++i) {
            // If the current character is different from the previous one
            // or it's the first character
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count[i] = 1; // Reset the count to 1
            } else {
                count[i] = count[i - 1] + 1; // Increment the count of consecutive occurrences
                // If the count becomes equal to k, it means k consecutive duplicates are found
                if (count[i] == k) {
                    // Remove these k characters from the string using StringBuilder's delete method
                    sb.delete(i - k + 1, i + 1);
                    // Adjust the loop counter i to handle the removed characters
                    i = i - k;
                }
            }
        }
        // Return the modified string
        return sb.toString();
    }
}
