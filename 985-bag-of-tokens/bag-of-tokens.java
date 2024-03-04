class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // Sorting the tokens in ascending order
        Arrays.sort(tokens);

        // Initializing pointers and variables
        int left = 0; // Pointer to the leftmost token
        int right = tokens.length - 1; // Pointer to the rightmost token
        int result = 0; // Variable to store the maximum score obtained
        int score = 0; // Variable to store the current score

        // Iterating until left pointer is less than or equal to right pointer
        while (left <= right) {
            // If we have enough power to play the leftmost token
            if (power >= tokens[left]) {
                power -= tokens[left]; // Deducting token power from our power
                left++; // Moving to the next token from the left
                score++; // Incrementing the score by 1
            }
            // If we have tokens to spend and our score is positive
            else if (score > 0 && left < right) {
                power += tokens[right]; // Gaining power by spending the rightmost token
                right--; // Moving to the next token from the right
                score--; // Decrementing the score by 1
            }
            // If we cannot make any more moves, 
            // returning the maximum score obtained
            else {
                return result;
            }
            // Updating the maximum score obtained so far
            result = Math.max(result, score);
        }
        // Returning the maximum score obtained after all possible moves
        return result;
    }
}
