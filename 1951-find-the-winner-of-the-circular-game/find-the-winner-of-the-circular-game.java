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
}