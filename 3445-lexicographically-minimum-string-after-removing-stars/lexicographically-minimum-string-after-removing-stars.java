class Solution {
    static public String clearStars(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // PriorityQueue to store [character value, index] and get smallest character
        // If tie on character, use most recent (higher index) first
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // prioritize later index if same char
            }
            return a[0] - b[0]; // otherwise, prioritize smaller character
        });

        boolean[] removed = new boolean[n]; // Marks which characters to ignore in final result

        // Traverse the input
        for (int i = 0; i < n; i++) {
            if (arr[i] == '*') {
                // Pop the smallest (and most recent) character from priority queue
                int[] top = pq.poll();
                removed[top[1]] = true; // mark that character as removed
            } else {
                // Push [charCode, index] into the heap
                pq.add(new int[]{ arr[i] - 'a', i });
            }
        }

        // Build result by skipping removed characters and '*'
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!removed[i] && arr[i] != '*') {
                sb.append(arr[i]);
            }
        }

        return sb.toString(); // Final cleaned string
    }
}
