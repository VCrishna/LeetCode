class Solution {
    public int findTheWinner(int n, int k) {
        // Creating a queue to represent the circle of players
        Queue<Integer> queue = new LinkedList<>();

        // Initializing the queue with player numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // Continue the elimination process until only one player remains
        while (queue.size() != 1) {
            // Rotate the queue (k-1) times, simulating 
            // the count to (k) and eliminating the player
            for (int i = 1; i <= k - 1; i++) {
                queue.add(queue.poll());
            }

            // Eliminating the k-th player
            queue.poll();
        }

        // Returning the player number of the remaining player (the winner)
        return queue.poll();
    }

    public int findTheWinner_recursion(int n, int k) {
        // Start the game with n friends and k steps
        return playGame(n, k);
    }
    
    private int playGame(int n, int k) {
        if (n == 1) {
            // If there's only one friend left, they are the winner
            return 1;
        } else {
            // Recursively play the game with n-1 friends (excluding the friend who loses)
            // Start the count from the friend immediately clockwise of the friend who loses,
            // and wrap around the circle if necessary
            return (playGame(n - 1, k) + k - 1) % n + 1;
        }
    }
}

