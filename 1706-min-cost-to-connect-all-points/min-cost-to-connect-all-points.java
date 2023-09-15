class Solution {
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        int cost = 0;
        Set<Integer> visitedSet = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); // edge weight(cost), the index of next node
        minHeap.offer(new int[] { 0, 0 });

        // When visitedSet.size() == points.len meaning that all the nodes has been connected.
        while (visitedSet.size() < length) {
            int[] arr = minHeap.poll();
            int weight = arr[0];
            int currentNode = arr[1];

            // checking if this node is visited already or not
            // if it is visited, we move to next iteration
            if (visitedSet.contains(currentNode)) continue;

            visitedSet.add(currentNode);
            cost += weight;

            for (int nextNode = 0; nextNode < length; nextNode++) {
                if (!visitedSet.contains(nextNode)) {
                    int nextWeight = Math.abs(points[nextNode][0] - points[currentNode][0]) + Math.abs(points[nextNode][1] - points[currentNode][1]);
                    // We only need to add the potentialWeight to the heap if it's lesser than the existing weight for that node.
                    // But since Java's PriorityQueue does not provide a method to update a specific entry, we'll add it regardless.
                    // Note: This will add duplicate entries for nodes but with different weights. The lowest weight will always be polled first.
                    minHeap.offer(new int[] { nextWeight, nextNode });
                }
            }
        }
        return cost;
    }
}
