class Solution {
    public List<Integer> partitionLabels(String s) {
        // Creating a list to store the length of each partition
        List<Integer> partitionLengths = new ArrayList<>();
        // Create an array to store the last index of each character in the string 's'.
        // The size is 26 because there are 26 lowercase letters.
        int[] lastIndexes = new int[26];
        // Filling up the lastIndexes array
        for (int i = 0; i < s.length(); i++)
            lastIndexes[s.charAt(i) - 'a'] = i;
        // Above line is determining the last occurrence of each character.
        // 's.charAt(i) - 'a'' computes the index for the respective character in lastIndexes array.
        // For example, if character is 'a', index would be 0, for 'b' it would be 1, and so on.
        int i = 0;
        // We'll scan the string until we've looked at every character
        while (i < s.length()) {
            // At start of each partition, note the last occurrence of the first character.
            // This is our initial partition end point.
            int end = lastIndexes[s.charAt(i) - 'a'];

            int j = i;
            // This loop is used to expand the partition until we ensure all characters within it
            // do not have a further occurrence beyond 'end'.
            while (j < end) {
                // If any character within current partition has its last occurrence beyond
                // the current 'end', we expand our partition to include that.
                end = Math.max(end, lastIndexes[s.charAt(j++) - 'a']);
            }
            // Add the partition length to our result list.
            partitionLengths.add(j - i + 1);

            // Move to the next possible start of partition
            i = j + 1;
        }
        return partitionLengths; // Return the list of partition lengths.
    }
}