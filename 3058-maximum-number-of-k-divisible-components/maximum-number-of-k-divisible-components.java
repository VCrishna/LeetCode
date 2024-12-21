class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        // given tree
        // given is tree with n nodes
        // only split a component if it can be in future be multiple of k
        // apply DFS

        List<Integer> adj[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        long out[] = new long[n];
        boolean vis[] = new boolean[n];

        dfs(n, 0, values, out, adj, vis);
        vis = new boolean[n];
        // System.out.println(Arrays.toString(out));

        int ans[] = { 1 };
        dfs2(0, k, out, adj, vis, ans);
        return ans[0];
    }

    public void dfs2(int cur, int k, long out[], List<Integer> adj[], boolean vis[], int ans[]) {
        vis[cur] = true;
        for (int x : adj[cur]) {
            if (!vis[x]) {
                if (out[x] % k == 0) {
                    ans[0]++;
                }
                dfs2(x, k, out, adj, vis, ans);
            }
        }
    }

    public long dfs(int n, int cur, int values[], long out[], List<Integer> adj[], boolean vis[]) {
        vis[cur] = true;
        out[cur] = (long) values[cur];
        for (int x : adj[cur]) {
            if (!vis[x]) {
                out[cur] += dfs(n, x, values, out, adj, vis);
            }
        }
        return out[cur];
    }

}