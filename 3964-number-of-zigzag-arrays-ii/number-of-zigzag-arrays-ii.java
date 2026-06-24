class Solution {

    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {

        /*
         * Number of distinct values available.
         *
         * Since only relative ordering matters, we can think of the values
         * as 0, 1, 2, ..., rangeSize - 1.
         */
        int rangeSize = r - l + 1;

        /*
         * Base vector.
         *
         * initialCounts[i] represents the number of valid zig-zag arrays
         * of length 2 whose second element has compressed value 'i'.
         *
         * There are exactly 'i' choices for the first element
         * (all smaller values).
         */
        long[] initialCounts = new long[rangeSize];
        for (int value = 0; value < rangeSize; value++) {
            initialCounts[value] = value;
        }

        /*
         * Transition matrix.
         *
         * transition[next][prev] = 1
         * if a state ending at 'prev' can transition to 'next'.
         *
         * Since the zig-zag direction alternates every step,
         * after normalization the valid transitions become:
         *
         * next + prev >= rangeSize
         *
         * which is exactly what this matrix stores.
         */
        long[][] transitionMatrix = new long[rangeSize][rangeSize];

        for (int nextValue = 1; nextValue < rangeSize; nextValue++) {
            for (int previousValue = rangeSize - nextValue;
                 previousValue < rangeSize;
                 previousValue++) {

                transitionMatrix[nextValue][previousValue] = 1;
            }
        }

        /*
         * Each multiplication extends the array by one position.
         *
         * We already know the counts for length = 2,
         * so we need (n - 2) more transitions.
         */
        long[][] poweredTransition =
                matrixPow(transitionMatrix, n - 2, rangeSize);

        /*
         * Multiply:
         *
         * final = (Transition^(n-2)) × BaseVector
         *
         * Sum every possible ending state.
         */
        long totalWays = 0;

        for (int row = 0; row < rangeSize; row++) {
            for (int col = 0; col < rangeSize; col++) {
                totalWays = (totalWays
                        + poweredTransition[row][col] * initialCounts[col]) % MOD;
            }
        }

        /*
         * The DP counts one zig-zag orientation.
         * Multiply by 2 for:
         *
         * Increase -> Decrease -> Increase...
         * Decrease -> Increase -> Decrease...
         */
        return (int) ((totalWays * 2) % MOD);
    }

    /*
     * Standard matrix multiplication.
     *
     * result = matrixA × matrixB
     */
    long[][] matrixMul(long[][] matrixA, long[][] matrixB, int size) {

        long[][] result = new long[size][size];

        for (int row = 0; row < size; row++) {

            for (int mid = 0; mid < size; mid++) {

                // Skip useless work.
                if (matrixA[row][mid] == 0) {
                    continue;
                }

                for (int col = 0; col < size; col++) {

                    result[row][col] =
                            (result[row][col]
                                    + matrixA[row][mid] * matrixB[mid][col])
                                    % MOD;
                }
            }
        }

        return result;
    }

    /*
     * Fast matrix exponentiation.
     *
     * Computes matrix^power in O(size^3 * log(power)).
     */
    long[][] matrixPow(long[][] matrix, int power, int size) {

        // Identity matrix.
        long[][] result = new long[size][size];
        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }

        while (power > 0) {

            if ((power & 1) == 1) {
                result = matrixMul(result, matrix, size);
            }

            matrix = matrixMul(matrix, matrix, size);
            power >>= 1;
        }

        return result;
    }
}