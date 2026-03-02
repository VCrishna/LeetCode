class Solution {

    public int minSwaps(int[][] grid) {

        int n = grid[0].length;

        /*
            trailingZeros[i] =
            number of consecutive zeros at the end of row i.
        */
        int[] trailingZeros = new int[n];

        // Step 1: Count trailing zeros for each row
        for (int row = 0; row < n; row++) {
            for (int col = n - 1; col >= 0; col--) {
                if (grid[row][col] == 0)
                    trailingZeros[row]++;
                else
                    break;  // stop once we hit a 1
            }
        }

        int[] totalSwaps = new int[1]; // using array to mutate inside method

        /*
            For each row position i,
            ensure it has enough trailing zeros.
        */
        for (int i = 0; i < n; i++) {
            if (!placeRow(trailingZeros, i, totalSwaps))
                return -1;
        }

        return totalSwaps[0];
    }

    /*
        Try to place a valid row at position i.

        Requirement:
        Row i must have at least (n - i - 1) trailing zeros.

        If current row doesn't satisfy,
        find a row below that does and bubble it up.
    */
    public boolean placeRow(int[] trailingZeros, int i, int[] totalSwaps) {

        int requiredZeros = trailingZeros.length - i - 1;

        // If already valid → no swap needed
        if (trailingZeros[i] >= requiredZeros)
            return true;

        // Search for a row below that satisfies condition
        for (int j = i + 1; j < trailingZeros.length; j++) {

            if (trailingZeros[j] >= requiredZeros) {

                // Number of adjacent swaps needed
                totalSwaps[0] += (j - i);

                /*
                    Bubble row j upward to position i.
                    Shift all rows between i and j down by 1.
                */
                int temp = trailingZeros[j];

                while (j > i) {
                    trailingZeros[j] = trailingZeros[j - 1];
                    j--;
                }

                trailingZeros[i] = temp;

                return true;
            }
        }

        // No valid row found
        return false;
    }
}