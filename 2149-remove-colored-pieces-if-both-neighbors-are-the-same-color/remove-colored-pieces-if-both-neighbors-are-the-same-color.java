class Solution {
    public boolean winnerOfGame(String colors) {
        // Count of sequences where Alice and Bob can remove characters
        // Alice count -- incremented when alice removes character A
        int aliceCount = 0, 
            // Bob count -- incremented when bob removes character A
            bobCount = 0,
            // Current count of consecutive 'A's and 'B's
            // Consecutive A's
            consecutiveA_sCount = 0, 
            // Consecutive B's
            consecutiveB_sCount = 0;
        // iterating over each character in the given colors string
        for(char ch : colors.toCharArray()) {
            if(ch == 'A') {
                // incrementing consecutive counts of A
                consecutiveA_sCount++;
                // resetting Consecutive B's count is A is occured
                consecutiveB_sCount = 0;
                // if A occurs 3 or more times consecutively in the colors string,
                // then alice can remove, so we are incrementing alice's count
                if(consecutiveA_sCount >= 3) aliceCount++;
            }
            else {
                consecutiveB_sCount++;
                consecutiveA_sCount = 0;// Reset consecutive A since we encountered a 'B'
                if(consecutiveB_sCount >= 3) bobCount++;// If 3 or more 'B's in a row, Bob can remove one
            }
        }

        return aliceCount > bobCount; // If Alice can remove more 'A's than Bob can remove 'B's, she wins
    }
}