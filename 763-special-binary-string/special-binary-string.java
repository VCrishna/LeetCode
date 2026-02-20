class Solution {

    public String makeLargestSpecial(String s) {

        /*
            A special binary string has:
            - Equal number of 1s and 0s
            - For every prefix: #1 >= #0

            This is exactly like valid parentheses:
                1 -> '('
                0 -> ')'
        */

        int balance = 0;   // tracks #1 - #0
        int segmentStart = 0;

        // Store top-level special substrings
        List<String> segments = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {

            // Update balance
            if (s.charAt(i) == '1')
                balance++;
            else
                balance--;

            /*
                When balance becomes 0,
                we found a top-level special substring.

                Example:
                s = "11011000"
                      ^      ^
                whole string is balanced
            */
            if (balance == 0) {

                /*
                    Structure of each balanced block:

                        1  +  inside  +  0

                    We recursively make the inside largest.
                */
                String inner = makeLargestSpecial(
                        s.substring(segmentStart + 1, i)
                );

                segments.add("1" + inner + "0");

                segmentStart = i + 1;
            }
        }

        /*
            Key Greedy Step:

            To make the whole string lexicographically largest,
            we sort the top-level segments in descending order.

            Larger prefix (more leading 1s) comes first.
        */
        Collections.sort(segments, Collections.reverseOrder());

        // Concatenate all segments
        return String.join("", segments);
    }
}
