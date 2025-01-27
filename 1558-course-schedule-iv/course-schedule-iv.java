class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        // Initializing an adjacency matrix to represent direct prerequisites
        boolean adjMatrix[][] = new boolean[n][n];

        // Populating the adjacency matrix with the given direct prerequisites
        for (int[] i : prerequisites) {
            adjMatrix[i[0]][i[1]] = true;
        }

        // Applying the Floyd-Warshall algorithm to compute the transitive closure
        // This will help in determining indirect prerequisites
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    adjMatrix[i][j] = adjMatrix[i][j] || (adjMatrix[i][k] && adjMatrix[k][j]);
                }
            }
        }

        // Preparing the result list to answer each query
        List<Boolean> ans = new ArrayList<Boolean>();

        // For each query, checking if the first course is a prerequisite of the second
        for (int i = 0; i < queries.length; ++i) {
            ans.add(adjMatrix[queries[i][0]][queries[i][1]]);
        }

        return ans;
    }
}
