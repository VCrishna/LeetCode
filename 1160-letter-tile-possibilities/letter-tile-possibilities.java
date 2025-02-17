class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26]; // Frequency array for letters A-Z (since tiles contain uppercase letters only)

        // Step 1: Count frequency of each letter in tiles
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++; // Convert character to index (0 for 'A', 1 for 'B', etc.) and update count
        }

        // Step 2: Use backtracking to generate all possible sequences
        return backtrack(freq);
    }

    private int backtrack(int[] freq) {
        int count = 0; // To count valid sequences
        // Step 3: Try using each letter (if available) to build sequences
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) { // If the letter is available
                freq[i]--; // Choose this letter and reduce its count
                count += 1 + backtrack(freq); // Count this sequence + explore further possibilities
                freq[i]++; // Backtrack: Restore letter count for other choices
            }
        }

        return count; // Return total count of sequences formed
    }
}
