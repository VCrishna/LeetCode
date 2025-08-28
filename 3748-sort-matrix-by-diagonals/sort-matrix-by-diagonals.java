import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Step 1: Collect elements of each diagonal into a map
        // Key = (row - col), Value = list of elements in that diagonal
        Map<Integer, List<Integer>> diagonals = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                diagonals.putIfAbsent(key, new ArrayList<>());
                diagonals.get(key).add(grid[i][j]);
            }
        }

        // Step 2: Sort each diagonal list based on region
        for (int key : diagonals.keySet()) {
            List<Integer> diag = diagonals.get(key);

            if (key >= 0) {
                // Bottom-left triangle (including main diagonal) → sort in DESC order
                diag.sort(Collections.reverseOrder());
            } else {
                // Top-right triangle → sort in ASC order
                Collections.sort(diag);
            }
        }

        // Step 3: Place sorted values back into the grid
        // We'll remove from list front while traversing again
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                List<Integer> diag = diagonals.get(key);
                grid[i][j] = diag.remove(0); // take next sorted element
            }
        }

        return grid;
    }
}
