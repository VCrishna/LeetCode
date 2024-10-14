class Solution {
    public long maxKelements(int[] arr, int k) {
        // Max Heap to keep elements in descending order
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        long result = 0;
        // Adding all elements from arr to the priority queue
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        // Execute k times to get the maximum k elements
        for (int i = 0; i < k; i++) {
            // Retrieve and remove the largest element
            int temp = queue.poll();
            result += temp;  // Add to the cumulative result

            // Modifing element as ceil(temp / 3) and 
            // adding it back to queue
            double s = (double) temp / 3;
            queue.add((int) Math.ceil(s));
        }
        return result;
    }
}
