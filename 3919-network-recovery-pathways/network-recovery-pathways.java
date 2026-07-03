class Solution {
    private record Pair(int v,int w){}
    private boolean hasPath(int[][] edges, boolean[] online,long k,int mid){
        int n = online.length;
        List<List<Pair>>adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int v = edge[1];
            if(edge[2]>=mid){
                adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
            }
        }

        PriorityQueue<long[]>pq = new PriorityQueue<>((a,b) -> Long.compare(a[1],b[1]));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        pq.offer(new long[]{0,0});
        dist[0] = 0;

        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            int u = (int)cur[0];
            long cost = cur[1]; 

            if(cost > dist[u]) continue;

            if(!online[u] && u != 0 && u != n - 1) continue;

            if(u == n - 1) return cost <= k;

            for(Pair pair : adj.get(u)){
                int v = pair.v();
                int edgeCost = pair.w();

                if(dist[u] + edgeCost < dist[v]){
                    dist[v] = dist[u] + edgeCost;
                    pq.offer(new long[]{v, dist[v]});
                }
            }
        }
        return dist[n-1] <= k;

    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int l=0;
        int ans = -1;

        int r = IntStream.range(0,edges.length).map(i -> edges[i][2]).max().orElse(0);

        while(l<=r){
            int mid = l+(r-l)/2;
            if(hasPath(edges,online,k,mid)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
}