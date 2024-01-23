class Solution {
    public int maxLength(List<String> arr) {
        // Initialize an array to store the result 
        // (using an array to pass by reference)
        int[] result = new int[1];
        // Starting the backtracking process
        backtrack(arr, 0, "", result);
        // Return the final result
        return result[0];
    }

    // Backtracking function to explore all possible concatenations
    public void backtrack(
            List<String> arr, // List of words
            int index, // Current index in the list
            String currentString, // Current concatenation of words
            int[] result // Array to store the result (maximum length)
    ) {
        // Checking if the current index is at the end of the list 
        // and the current  concatenation has more unique characters
        if (index == arr.size() && noOfUniqueCharacters(currentString) > result[0]) {
            result[0] = noOfUniqueCharacters(currentString); // Updating the result with the new maximum length
            return;
        }

        // Checking if the current index is at the end of the list
        if (index == arr.size()) {
            return;
        }

        // Considering the current word (concatenate it)
        backtrack(arr, index + 1, currentString + arr.get(index), result);

        // Not considering the current word
        backtrack(arr, index + 1, currentString, result);
    }

    // Function to calculate the number of unique characters in a string
    public int noOfUniqueCharacters(String s) {
        int[] count = new int[26]; // Array to store the count of characters (assuming lowercase English letters)
        for (char c : s.toCharArray()) {
            if (count[c - 'a']++ > 0) { // If a character is repeated, return -1
                return -1;
            }
        }
        return s.length(); // Return the length of the string if all characters are unique
    }
}