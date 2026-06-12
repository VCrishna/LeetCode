class Solution {

    // Modulo for large answers
    private final int mod = (int) 1e9 + 7;

    // Tree adjacency list
    private List<Integer>[] adList;

    /*
        For Tarjan's Offline LCA algorithm.

        lcaQueries[node] stores:
        (otherNode, queryIndex)
    */
    private List<Pair>[] lcaQueries;

    // Stores the LCA for every query
    private int[] lca;

    // Marks whether a node has been completely processed
    private boolean[] vis;

    // Depth of every node from the root
    private int[] depth;

    // Union-Find structure used in Tarjan's algorithm
    private UnionFind uf;

    /*
        Stores:
            first  -> other endpoint of query
            second -> index of query
    */
    private class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    /*
        Standard Disjoint Set Union (Union-Find)
        with path compression.
    */
    private class UnionFind {

        private int[] set;

        public UnionFind(int n) {
            set = new int[n];

            for (int i = 0; i < n; i++) {
                set[i] = i;
            }
        }

        int find(int node) {

            if (set[node] == node) {
                return node;
            }

            return set[node] = find(set[node]);
        }

        void merge(int u, int v) {

            int rootU = find(u);
            int rootV = find(v);

            set[rootU] = rootV;
        }
    }

    /*
        Tarjan's Offline Lowest Common Ancestor DFS.

        Intuition:
        ----------
        - DFS traverses the tree.
        - After completely processing a subtree,
          it merges the child into its parent.
        - If the opposite endpoint of a query
          has already been visited, its DSU
          representative is the LCA.
    */
    void dfs(int node, int currentDepth, int parent) {

        depth[node] = currentDepth;

        // Visit children
        for (int neighbour : adList[node]) {

            if (neighbour != parent) {
                dfs(neighbour, currentDepth + 1, node);
            }
        }

        /*
            Resolve all LCA queries involving
            the current node.
        */
        for (Pair query : lcaQueries[node]) {

            if (vis[query.first]) {

                int queryIndex = query.second;

                lca[queryIndex] = uf.find(query.first);
            }
        }

        // Mark this node as processed
        vis[node] = true;

        // Merge current node into its parent
        if (parent != -1) {
            uf.merge(node, parent);
        }
    }

    /*
        Fast modular exponentiation.

        Computes:
            base^power % mod

        in O(log power).
    */
    private int binaryExponentiation(int base, int power) {

        if (power < 0) {
            return 0;
        }

        int result = 1;

        while (power > 0) {

            if ((power & 1) == 1) {
                result = (int) (((long) result * base) % mod);
            }

            base = (int) (((long) base * base) % mod);

            power >>= 1;
        }

        return result;
    }

    /*
        Distance between two nodes in a tree:

        dist(u, v) =
            depth[u] + depth[v]
            - 2 * depth[LCA]
    */
    private int distanceBetweenNode(int u, int v, int lcaNode) {

        return depth[u] + depth[v] - 2 * depth[lcaNode];
    }

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        int n = edges.length + 1;
        int queryCount = queries.length;

        /*
            -------------------------
            Step 1: Build the tree
            -------------------------
        */
        adList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {

            // Convert to 0-based indexing
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            adList[u].add(v);
            adList[v].add(u);
        }

        /*
            Initialize helper structures.
        */
        lca = new int[queryCount];
        depth = new int[n];

        uf = new UnionFind(n);

        vis = new boolean[n];

        lcaQueries = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            lcaQueries[i] = new ArrayList<>();
        }

        /*
            Store every query at both endpoints.

            This allows Tarjan's algorithm to answer
            the query when both nodes have been visited.
        */
        for (int i = 0; i < queryCount; i++) {

            int u = queries[i][0] - 1;
            int v = queries[i][1] - 1;

            lcaQueries[u].add(new Pair(v, i));
            lcaQueries[v].add(new Pair(u, i));
        }

        /*
            Run Tarjan Offline LCA from root.
        */
        dfs(0, 0, -1);

        int[] answer = new int[queryCount];

        /*
            Compute answer for every query.
        */
        for (int i = 0; i < queryCount; i++) {

            int lcaNode = lca[i];

            // Same node → distance = 0
            if (queries[i][0] == queries[i][1]) {

                answer[i] = 0;
            }
            else {

                int distance = distanceBetweenNode(
                    queries[i][0] - 1,
                    queries[i][1] - 1,
                    lcaNode
                );

                /*
                    Problem-specific observation:

                    Number of valid assignments
                    = 2^(distance - 1)
                */
                answer[i] = binaryExponentiation(2, distance - 1);
            }
        }

        return answer;
    }
}