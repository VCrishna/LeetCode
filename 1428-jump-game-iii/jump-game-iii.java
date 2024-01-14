class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        
        // Array to track visited indices
        boolean[] visited = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        // Performing BFS traversal
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Marking the current index as visited
            visited[current] = true;

            // If the value at the current index is zero, returning true
            if (arr[current] == 0) {
                return true;
            }

            // Calculating the indices to the left and right based on the current index and array value
            int left = current - arr[current];
            int right = current + arr[current];

            // Enqueue the left index if it is valid and not visited
            if (left >= 0 && !visited[left]) {
                queue.add(left);
            }
            
            // Enqueue the right index if it is valid and not visited
            if (right < n && !visited[right]) {
                queue.add(right);
            }
        }
        // If no zero is reached during BFS traversal, returning false
        return false;
    }
}
