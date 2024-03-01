class Solution {
    public String maximumOddBinaryNumber(String s) {
        // Counting the number of ones and zeros in the input string
        int ones = 0, zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else {
                zeros++;
            }
        }

        // Constructing the maximum odd binary number
        StringBuilder sb = new StringBuilder();
        // Appending 'ones - 1' ones to ensure the number is odd
        for (int i = 0; i < ones - 1; i++) {
            sb.append("1");
        }
        // Appending all zeros
        for (int i = 0; i < zeros; i++) {
            sb.append("0");
        }
        // Appending one more 1 to maintain oddness
        sb.append("1");

        // Returning the constructed maximum odd binary number
        return sb.toString();
    }
}
