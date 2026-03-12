class DSU {

    int vertices;
    int[] parent;
    int[] rank;

    public DSU(int v) {

        vertices = v;
        parent = new int[v];
        rank = new int[v];

        // Initially each node is its own parent
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
    }

    /*
        Find the representative (root) of the component.
        Uses path compression for optimization.
    */
    public int findparent(int node) {

        if (parent[node] == node)
            return node;

        return parent[node] = findparent(parent[node]);
    }

    /*
        Union two components using union-by-rank.
    */
    public void union(int u, int v) {

        int rootU = findparent(u);
        int rootV = findparent(v);

        if (rank[rootU] == rank[rootV]) {
            parent[rootU] = rootV;
            rank[rootV]++;
        }
        else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
        else {
            parent[rootU] = rootV;
            rank[rootV]++;
        }
    }
}


class Solution {

    public int maxStability(int n, int[][] edges, int k) {

        DSU dsu = new DSU(n);

        /*
            Priority queue for optional edges.
            We process highest weight first.
        */
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[2] - a[2]);

        int minMandatoryEdge = Integer.MAX_VALUE;
        int edgeCount = 0;

        /*
            Step 1:
            Process mandatory edges first.
        */
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            int mandatory = edge[3];

            if (mandatory == 1) {

                // If they already belong to same component → cycle
                if (dsu.findparent(u) == dsu.findparent(v)) {
                    return -1;
                }

                dsu.union(u, v);

                minMandatoryEdge = Math.min(minMandatoryEdge, weight);

                edgeCount++;
            }
            else {

                // Store optional edges for later
                pq.offer(new int[] {u, v, weight});
            }
        }

        int minOptionalEdge = Integer.MAX_VALUE;

        /*
            Step 2:
            Use optional edges to finish the spanning tree.
        */
        while (!pq.isEmpty()) {

            int[] edge = pq.poll();

            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            // Skip if this creates a cycle
            if (dsu.findparent(u) == dsu.findparent(v))
                continue;

            if (edgeCount == n - 1)
                break;

            dsu.union(u, v);
            edgeCount++;

            /*
                Special handling depending on
                how many optional edges are used.
            */
            if (edgeCount <= n - 1 - k) {

                minOptionalEdge =
                    Math.min(minOptionalEdge, weight);

            }
            else {

                minOptionalEdge =
                    Math.min(minOptionalEdge, weight * 2);
            }
        }

        /*
            If we couldn't build a spanning tree
        */
        if (edgeCount != n - 1)
            return -1;

        /*
            Stability depends on minimum
            contributing edge.
        */
        return Math.min(minMandatoryEdge, minOptionalEdge);
    }
}