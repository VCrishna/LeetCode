class Solution {
    public int minCost(int n, int[][] edges) {

        // out[u]  -> list of edges going out from node u (u -> v with cost w)
        // in[u]   -> list of edges coming into node u (v -> u with cost w)
        // We store both to easily support edge reversal
        List<List<int[]>> out = new ArrayList<>();
        List<List<int[]>> in = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            out.add(new ArrayList<>());
            in.add(new ArrayList<>());
        }

        // Build adjacency lists
        for (int[] e : edges) {
            // Normal directed edge
            out.get(e[0]).add(new int[]{e[1], e[2]});

            // Reverse reference (used when we "reverse" an edge)
            in.get(e[1]).add(new int[]{e[0], e[2]});
        }

        // A very large number to represent "infinity"
        long INF = (long) 1e18;

        /*
         dist[u][0] -> minimum cost to reach node u WITHOUT using reversal yet
         dist[u][1] -> minimum cost to reach node u AFTER using reversal
         
         This is a classic Dijkstra-with-state approach.
        */
        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        /*
         Priority queue stores:
         [totalCostSoFar, currentNode, reversalUsedFlag]
         
         Always expands the state with minimum cost so far
        */
        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        // Start from node 0, cost = 0, reversal not used
        dist[0][0] = 0;
        pq.add(new long[]{0, 0, 0});

        // Standard Dijkstra loop
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long cost = cur[0];
            int u = (int) cur[1];
            int used = (int) cur[2];

            // Ignore outdated states
            if (cost > dist[u][used]) continue;

            // --------------------------------------------------
            // 1️⃣ Traverse normal edges (u -> v) with cost w
            // These do NOT consume the reversal operation
            // --------------------------------------------------
            for (int[] edge : out.get(u)) {
                int v = edge[0];
                int w = edge[1];

                // Relax the edge
                if (dist[v][0] > cost + w) {
                    dist[v][0] = cost + w;
                    pq.add(new long[]{dist[v][0], v, 0});
                }
            }

            // --------------------------------------------------
            // 2️⃣ Traverse reversed edges (only if not used yet)
            // Reversing an edge costs 2 * w
            // This operation can be used ONLY ONCE
            // --------------------------------------------------
            if (used == 0) {
                for (int[] edge : in.get(u)) {
                    int v = edge[0];
                    int w = edge[1];

                    // Cost of reversing the edge
                    if (dist[v][0] > cost + 2L * w) {
                        dist[v][0] = cost + 2L * w;
                        pq.add(new long[]{dist[v][0], v, 0});
                    }
                }
            }
        }

        // We take the minimum cost to reach destination node
        long ans = Math.min(dist[n - 1][0], dist[n - 1][1]);

        // If unreachable, return -1
        return ans >= INF ? -1 : (int) ans;
    }
}
