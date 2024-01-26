class Solution {
    int MOD = (int) 1e9 + 7;
    int rows;
    int columns;
    Map<String, Integer> memo;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        rows = m;
        columns = n;
        memo = new HashMap<>();
        return dfs(startRow, startColumn, maxMove);
    }

    public int dfs(int startRow, int startColumn, int maxMove) {
        if (startRow < 0 || startRow == rows ||
                startColumn < 0 || startColumn == columns) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
        String key = startRow + "_" + startColumn + "_" + maxMove;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int result = ((dfs(startRow + 1, startColumn, maxMove - 1) + dfs(startRow - 1, startColumn, maxMove - 1)) % MOD
                +
                (dfs(startRow, startColumn + 1, maxMove - 1) + dfs(startRow, startColumn - 1, maxMove - 1)) % MOD)
                % MOD;

        memo.put(key, result);
        return result;
    }
}