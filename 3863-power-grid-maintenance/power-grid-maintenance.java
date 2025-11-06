class Solution {
    int[] parent, size;
    // For each DSU component root -> a min-heap storing all nodes in that component
    Map<Integer, PriorityQueue<Integer>> mp = new HashMap<>();

    // Standard path compression find
    int findParent(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    // Union by size + merge heaps
    void Union(int u, int v) {
        int up = findParent(u);
        int vp = findParent(v);

        if (up == vp) return; // already connected

        // Always merge smaller component into bigger one (union by size)
        if (size[up] > size[vp]) {
            size[up] += size[vp];
            parent[vp] = up;

            // Merge pq of vp into up
            PriorityQueue<Integer> pqV = mp.get(vp);
            PriorityQueue<Integer> pqU = mp.get(up);
            while (!pqV.isEmpty()) pqU.offer(pqV.poll());
        } else {
            size[vp] += size[up];
            parent[up] = vp;

            // Merge pq of up into vp
            PriorityQueue<Integer> pqU = mp.get(up);
            PriorityQueue<Integer> pqV = mp.get(vp);
            while (!pqU.isEmpty()) pqV.offer(pqU.poll());
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c];
        size = new int[c];
        boolean[] offline = new boolean[c];  // track offline nodes

        // Initialize DSU + each node in its own heap
        for (int i = 0; i < c; i++) {
            parent[i] = i;
            size[i] = 1;

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(i);       // each component initially contains only itself
            mp.put(i, pq);
        }

        // Build connected components before queries
        for (int[] conn : connections) {
            int u = conn[0] - 1, v = conn[1] - 1;
            Union(u, v);
        }

        List<Integer> ans = new ArrayList<>();

        // Process queries
        for (int[] q : queries) {
            int type = q[0];
            int node = q[1] - 1;

            if (type == 1) {
                // Query: find smallest online node in this component

                if (!offline[node]) {
                    // If the node itself is online → it *is* the smallest candidate
                    ans.add(node + 1);
                    continue;
                }

                int par = findParent(node);
                PriorityQueue<Integer> pq = mp.get(par);

                // Remove nodes that are offline from top of heap
                while (!pq.isEmpty() && offline[pq.peek()]) pq.poll();

                // If empty → no online nodes
                ans.add(pq.isEmpty() ? -1 : pq.peek() + 1);

            } else {
                // type 2 → mark offline
                offline[node] = true;
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
