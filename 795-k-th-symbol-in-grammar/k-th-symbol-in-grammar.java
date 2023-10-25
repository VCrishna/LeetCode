class Solution {
    /**
    The basic idea is to use the properties of the sequence:
    
    The first number is always 0.
    The 0th and 1st element in row N is like the 0th element in row N-1.
    The 2nd and 3rd element in row N is like the 1st element in row N-1.
    The 4th and 5th element in row N is like the 2nd element in row N-1.... and so on.
    
    When k is even, it is the reverse of the previous element. If k is odd, it's the same.
     */

    public int kthGrammar(int n, int k) {
        // Base case: For the first row, the value is always 0.
        if (n == 1) 
            return 0;
        // Check if k is even or odd.
        // If k is even, then the value at this position is determined by the value at position k/2 in the previous row.
        // Essentially, each pair of numbers in the current row maps to a single number in the previous row.
        // If the value in the previous row is 0, the pair is "01", and if it's 1, the pair is "10".
        // Since k is even, we are looking at the second number in the pair, 
        // so the value is the opposite of the value in the previous row.
        if (k % 2 == 0) 
            return (kthGrammar(n - 1, k / 2) == 0) ? 1 : 0;
        // If k is odd, then the value at this position is the same as the value 
        // at position (k+1)/2 in the previous row. 
        // This is because we are looking at the first number in the pair.
        else 
            return kthGrammar(n - 1, (k + 1) / 2);
    }

    public int kthGrammar_BRUTE_FORCE(int n, int k) {
        String[] table = new String[n];
        table[0] = "0";
        for (int i = 1; i < n; i++) {
            StringBuilder currentRow = new StringBuilder();
            String prevRow = table[i - 1];
            for (char c : prevRow.toCharArray()) {
                if (c == '0') {
                    currentRow.append("01");
                } else {
                    currentRow.append("10");
                }
            }
            table[i] = currentRow.toString();
        }
        return Character.getNumericValue(table[n - 1].charAt(k - 1));
    }
}
