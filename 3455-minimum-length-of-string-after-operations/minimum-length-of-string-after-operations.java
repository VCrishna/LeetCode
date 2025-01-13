class Solution {
    public int minimumLength(String s) {
        // Step 1: Create an array to store the frequency of each character in the
        // string.
        int[] charFreq = new int[26]; // Array to hold counts for each letter ('a' to 'z')
        int result = 0; // Initialize the result to store the minimum length

        // Step 2: Iterate through the string to calculate character frequencies.
        for (char ch : s.toCharArray()) {
            // Convert character to an index (0 for 'a', 1 for 'b', ..., 25 for 'z')
            charFreq[ch - 'a']++;
        }

        // Step 3: Process each character's frequency to compute the minimum length.
        for (int i : charFreq) {
            // While the frequency is 3 or more, repeatedly reduce it by 2.
            // Intuition: Remove two identical characters in a single operation.
            while (i >= 3) {
                i -= 2; // Remove two characters, leaving at most one.
            }
            // Add the remaining count (1 or 2) to the result.
            result += i;
        }

        // Step 4: Return the computed minimum length of the string.
        return result;
    }
}
