class Solution {

    public int longestBalanced(String s) {

        int length = s.length();
        int maxLength = 0;

        /*
            We try every possible starting index.
            For each start, we extend the substring to the right.
        */
        for (int start = 0; start < length; start++) {

            // frequency of each character in current substring
            int[] frequency = new int[26];

            int distinctCount = 0;   // number of distinct characters
            int maxFrequency = 0;    // highest frequency among characters

            for (int end = start; end < length; end++) {

                char currentChar = s.charAt(end);
                int index = currentChar - 'a';

                /*
                    If this character appears first time in this substring,
                    increase distinct character count.
                */
                if (frequency[index] == 0) {
                    distinctCount++;
                }

                frequency[index]++;

                // Update maximum frequency seen so far
                maxFrequency = Math.max(maxFrequency, frequency[index]);

                /*
                    Balanced condition:

                    maxFrequency * distinctCount == substring length

                    Why?

                    Suppose:
                    - There are k distinct characters
                    - Each appears exactly f times

                    Then total length = k * f

                    If maxFrequency * distinctCount equals total length,
                    that means all characters must have equal frequency.
                */
                int currentLength = end - start + 1;

                if (maxFrequency * distinctCount == currentLength) {
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }

        return maxLength;
    }
}
