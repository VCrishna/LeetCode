class Solution {
    public long minimumCost(
        String source,
        String target,
        String[] original,
        String[] changed,
        int[] cost
    ) {

        int n = source.length();

        /*
         STEP 1: Map every unique transformation string
         (from original and changed arrays) to a unique node ID.
         This lets us build a graph on strings.
        */
        Map<String, Integer> strToId = new HashMap<>();
        int idCounter = 0;

        for (String s : original)
            if (!strToId.containsKey(s))
                strToId.put(s, idCounter++);

        for (String s : changed)
            if (!strToId.containsKey(s))
                strToId.put(s, idCounter++);

        /*
         STEP 2: Build distance matrix for all string transformations.
         dist[u][v] = minimum cost to convert string u → string v.
        */
        long INF = 1_000_000_000_000_000L;
        long[][] dist = new long[idCounter][idCounter];

        for (int i = 0; i < idCounter; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // cost to convert a string to itself
        }

        /*
         Direct transformation costs from input
        */
        for (int i = 0; i < original.length; i++) {
            int u = strToId.get(original[i]);
            int v = strToId.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], (long) cost[i]);
        }

        /*
         STEP 3: Floyd–Warshall
         Compute minimum cost between all pairs of strings,
         allowing multi-step transformations.
        */
        for (int k = 0; k < idCounter; k++) {
            for (int i = 0; i < idCounter; i++) {
                for (int j = 0; j < idCounter; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] =
                            Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        /*
         STEP 4: DP on the source string
         dp[i] = minimum cost to transform source[0..i-1]
                 into target[0..i-1]
        */
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        /*
         We only need to try substring lengths that actually appear
         in the transformation rules.
        */
        Set<Integer> uniqueLens = new HashSet<>();
        for (String s : original)
            uniqueLens.add(s.length());
        Integer[] lens = uniqueLens.toArray(new Integer[0]);

        /*
         STEP 5: Main DP transitions
        */
        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue; // unreachable state

            /*
             Case 1: Characters already match → move one step for free
            */
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            /*
             Case 2: Try replacing substrings using transformation rules
            */
            for (int len : lens) {
                if (i + len <= n) {

                    String subS = source.substring(i, i + len);
                    String subT = target.substring(i, i + len);

                    /*
                     If substrings already match → free transition
                    */
                    if (subS.equals(subT)) {
                        dp[i + len] = Math.min(dp[i + len], dp[i]);
                    }

                    /*
                     Otherwise, check if transformation exists
                     and use the precomputed shortest cost
                    */
                    else if (
                        strToId.containsKey(subS) &&
                        strToId.containsKey(subT)
                    ) {
                        int u = strToId.get(subS);
                        int v = strToId.get(subT);

                        if (dist[u][v] < INF) {
                            dp[i + len] =
                                Math.min(dp[i + len], dp[i] + dist[u][v]);
                        }
                    }
                }
            }
        }

        /*
         Final answer: cost to transform entire string
        */
        return dp[n] >= INF ? -1 : dp[n];
    }
}
