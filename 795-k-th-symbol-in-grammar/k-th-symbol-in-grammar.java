class Solution {

    public int kthGrammar(int n, int k) {
        if (n == 1) 
            return 0; // base case
        if (k % 2 == 0) 
            return (kthGrammar(n - 1, k / 2) == 0) ? 1 : 0; 
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
