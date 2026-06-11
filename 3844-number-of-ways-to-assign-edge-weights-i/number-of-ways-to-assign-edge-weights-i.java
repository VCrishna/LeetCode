class Solution {

    static final int MOD = 1_000_000_007;

    /*
        Fast modular exponentiation.

        Computes:
            a^b % MOD

        in O(log b) time by repeatedly squaring the base.
    */
    private long power(long a, long b) {

        long result = 1;

        while (b > 0) {

            // If current bit of exponent is set,
            // include current power of 'a' in the answer.
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }

            // Square the base for the next bit.
            a = (a * a) % MOD;

            // Move to the next bit of the exponent.
            b >>= 1;
        }

        return result;
    }

    public int assignEdgeWeights(int[][] edges) {

        /*
            A tree with n nodes always has n - 1 edges.
        */
        int n = edges.length + 1;

        /*
            Build the adjacency list representation
            of the tree.
        */
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        /*
            Perform BFS starting from node 1 to compute
            the maximum depth of the tree.

            Queue stores:
                {currentNode, currentDepth}
        */
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(new int[] {1, 0});
        visited[1] = true;

        int maximumDepth = 0;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int node = current[0];
            int depth = current[1];

            // Keep track of the deepest level reached.
            maximumDepth = Math.max(maximumDepth, depth);

            for (int neighbour : adjacencyList.get(node)) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;

                    queue.offer(new int[] {
                        neighbour,
                        depth + 1
                    });
                }
            }
        }

        /*
            Intuition:

            The number of valid assignments depends only
            on the maximum depth of the tree.

            Once the maximum depth is known, the answer is:

                2^(maximumDepth - 1)

            computed modulo 1e9 + 7.
        */
        return (int) power(2, maximumDepth - 1);
    }
}