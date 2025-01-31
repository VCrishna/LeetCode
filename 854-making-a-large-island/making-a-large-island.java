import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length; // Get the size of the grid (assuming it's n x n)
        int islandId = 2; // Start assigning unique IDs to islands from 2
        Map<Integer, Integer> islandSizes = new HashMap<>(); // Map to store the size of each island by its ID

        // Step 1: Identify and label all islands with unique IDs, and calculate their
        // sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // Found an unvisited land cell
                    int size = dfs(grid, i, j, islandId); // Perform DFS to label the island and calculate its size
                    islandSizes.put(islandId, size); // Store the size of the island
                    islandId++; // Increment the island ID for the next island
                }
            }
        }

        // Step 2: Determine the maximum possible island size by flipping one 0 to 1
        int maxSize = islandSizes.isEmpty() ? 0 : Collections.max(islandSizes.values()); // Initialize maxSize with the
                                                                                         // size of the largest existing
                                                                                         // island

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) { // Found a water cell
                    Set<Integer> neighbors = new HashSet<>(); // Set to store unique neighboring island IDs
                    // Check all four possible directions (up, down, left, right)
                    for (int[] dir : new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }) {
                        int x = i + dir[0], y = j + dir[1];
                        // Ensure the neighboring cell is within bounds and is part of an island
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] != 0) {
                            neighbors.add(grid[x][y]); // Add the island ID to the set
                        }
                    }

                    int total = 1; // Start with 1 to account for the flipped cell
                    // Sum the sizes of all unique neighboring islands
                    for (int neighborId : neighbors) {
                        total += islandSizes.getOrDefault(neighborId, 0);
                    }
                    // Update maxSize if the new total is larger
                    maxSize = Math.max(maxSize, total);
                }
            }
        }

        return maxSize; // Return the largest possible island size
    }

    private int dfs(int[][] grid, int i, int j, int islandId) {
        int n = grid.length;
        // Base case: if out of bounds or not land, return 0
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = islandId; // Label the current cell with the island ID
        int size = 1; // Start with size 1 for the current cell
        // Recursively visit all four neighboring cells to calculate the total size of
        // the island
        size += dfs(grid, i + 1, j, islandId);
        size += dfs(grid, i - 1, j, islandId);
        size += dfs(grid, i, j + 1, islandId);
        size += dfs(grid, i, j - 1, islandId);
        return size; // Return the total size of the island
    }
}
