class Solution {
    public int[] maxPoints(int[][] arr, int[] q) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.add(new int[] { arr[0][0], 0, 0 });
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[0][0] = true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < q.length; i++) {
            if (map.get(q[i]) == null) {
                map.put(q[i], new ArrayList<>());
            }
            map.get(q[i]).add(i);
        }

        Arrays.sort(q);
        int ix = 0;
        int cur = 0;
        int[] res = new int[q.length];

        int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

        while (!pq.isEmpty()) {
            int[] rem = pq.remove();

            while (ix < q.length && q[ix] <= rem[0]) {
                res[ix] = cur;
                ix++;
            }
            if (ix >= q.length)
                break;
            cur++;

            for (int d[] : dir) {
                int x = d[0] + rem[1];
                int y = d[1] + rem[2];

                if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                pq.add(new int[] { arr[x][y], x, y });
            }
        }
        while (ix < q.length) {
            res[ix] = cur;
            ix++;
        }

        int[] ans = new int[q.length];
        int p = 0;
        for (int x : q) {

            for (int i : map.get(x)) {
                ans[i] = res[p];
            }
            p++;
        }

        return ans;
    }
}