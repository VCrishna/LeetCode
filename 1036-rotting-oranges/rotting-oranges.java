class Solution {
    public int orangesRotting(int[][] grid) {
        // Set to store coordinates of fresh oranges
        Set<String> fresh = new HashSet<>();
        // Set to store coordinates of rotten oranges
        Set<String> rotten = new HashSet();

        // Populating fresh and rotten sets based on the initial state of the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(i + "," + j);
                } else if (grid[i][j] == 1) {
                    fresh.add(i + "," + j);
                }
            }
        }

        // Variable to keep track of minutes elapsed
        int minutes = 0;
        // Array to represent possible directions (up, down, left, right)
        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        // Continuing the process until there are fresh oranges
        while (fresh.size() > 0) {
            // Set to store newly infected oranges in the current minute
            Set<String> infected = new HashSet<>();

            // Iterating through each rotten orange and try to infect adjacent fresh oranges
            for (String s : rotten) {
                String[] indices = s.split(",");
                int i = Integer.parseInt(indices[0]);
                int j = Integer.parseInt(indices[1]);

                for (int[] direction : directions) {
                    int nextI = i + direction[0];
                    int nextJ = j + direction[1];

                    // If the adjacent cell has a fresh orange, mark it as infected
                    if (fresh.contains(nextI + "," + nextJ)) {
                        fresh.remove(nextI + "," + nextJ);
                        infected.add(nextI + "," + nextJ);
                    }
                }
            }

            // If no new oranges are infected, it means there are isolated fresh oranges
            if (infected.size() == 0) {
                return -1;
            }

            // Update the set of rotten oranges for the next minute
            rotten = infected;
            // Increment the minute counter
            minutes++;
        }

        // Return the total minutes required to infect all fresh oranges
        return minutes;
    }
}
