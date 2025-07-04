class Solution {
    public char kthCharacter(long k, int[] operations) {
        // Find the index of the highest power of 2 <= k
        // This gives us an upper bound on which operation contributes to the kth character
        int i = (int) (Math.ceil(Math.log(k) / Math.log(2))) - 1;
        int count = 0; // to count how many '1's are involved before reaching k
        // Traverse backwards from highest power bit
        while (k > 1) {
            // If k is greater than the size of segment from operation[i], move into next segment
            if (k > (1L << i)) {
                // If this segment (operation) was a '1', count it
                if (operations[i] == 1) {
                    count++;
                }
                // Subtract the size of current segment from k to move within the next block
                k -= (1L << i);
            }
            i--; // Move to the next lower segment
        }
        // The character is determined by how many '1' operations were seen
        // Offset from 'a' by count % 26 (wrap around alphabet)
        return (char) ('a' + (count % 26));
    }
}
