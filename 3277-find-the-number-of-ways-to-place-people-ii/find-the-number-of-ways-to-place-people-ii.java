class Solution {
    public int numberOfPairs(int[][] A) {
        int res = 0, n = A.length;

        // Step 1: Sort points by X ascending.
        // If X is equal, sort by Y descending.
        // Why? 
        //   - Sorting by X ascending ensures we only need to look forward for valid pairs.
        //   - Sorting ties by Y descending prevents double-counting when X values are equal.
        Arrays.sort(A, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        // Step 2: For each point A[i], try to find all valid A[j] (j > i) 
        // that can form a pair with it.
        for (int i = 0; i < n; ++i) {
            // "y" keeps track of the largest Y we’ve already paired with A[i]
            // to avoid counting weaker (smaller) Ys multiple times.
            int y = -(int) 2e9;

            // Step 3: Scan forward to find valid pairs
            for (int j = i + 1; j < n; ++j) {
                // Condition 1: A[i].y >= A[j].y
                //   ensures dominance (the upper point dominates the lower one).
                // Condition 2: A[j].y > y
                //   ensures we only pick the best candidate for each level of Y.
                if (A[i][1] >= A[j][1] && A[j][1] > y) {
                    res++; // Found a valid pair (i, j)
                    y = A[j][1]; // Update boundary to prevent weaker duplicates
                }
            }
        }

        // Step 4: Return total pairs found
        return res;
    }

}