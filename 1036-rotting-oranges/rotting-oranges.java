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
    public int orangesRotting_QUEUE_DFS(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // Queue to store the coordinates of rotten oranges
        Queue<int[]> queue = new LinkedList<>();

        // Variable to count the number of fresh oranges
        int fresh = 0;

        // Iterating through the grid to populate the queue and count fresh oranges
        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j += 1) {
                if (grid[i][j] == 2) {
                    // Add coordinates of rotten oranges to the queue
                    queue.offer(new int[] { i, j });

                }
                else if (grid[i][j] == 1) {
                    // Count fresh oranges
                    fresh += 1;
                }
            }
        }

        // Variable to keep track of minutes
        int count = 0;

        // Array to represent possible directions (up, down, left, right)
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        // Continuing the process until the queue is empty 
        // or there are no more fresh oranges
        while (!queue.isEmpty() && fresh != 0) {
            // Increment the minute counter
            count += 1;
            int sz = queue.size();

            // Processing each rotten orange in the current minute
            for (int i = 0; i < sz; i += 1) {
                // Retrieving the coordinates of a rotten orange
                int[] rotten = queue.poll();
                int r = rotten[0], c = rotten[1];

                // Exploring adjacent cells (up, down, left, right) of the current rotten orange
                for (int[] dir : dirs) {
                    int x = r + dir[0], y = c + dir[1];

                    // Check if the adjacent cell is within the grid boundaries and 
                    // contains a fresh orange
                    if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2; // Mark the fresh orange as rotten
                        queue.offer(new int[] { x, y }); // Add the coordinates to the queue
                        fresh -= 1; // Decrement the count of fresh oranges
                    }
                }
            }
        }

        // Return the total minutes required to infect all fresh oranges or -1 if there
        // are isolated fresh oranges
        return fresh == 0 ? count : -1;
    }
}
