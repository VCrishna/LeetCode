class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;

            if (arr[current] == 0) {
                return true;
            }

            int left = current - arr[current];
            int right = current + arr[current];

            if (left >= 0 && !visited[left]) {
                queue.add(left);
            }
            if (right < n && !visited[right]) {
                queue.add(right);
            }
        }

        return false;
    }
}
