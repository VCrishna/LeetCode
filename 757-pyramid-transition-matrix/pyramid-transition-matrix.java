class Solution {

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        // map[a][b] → list of characters that can sit on top of (a, b)
        // We only need size 6 since problem constraints limit characters
        List<Character>[][] map = new List[6][6];

        // Memoization: stores whether a row can lead to a valid pyramid
        Map<String, Boolean> memo = new HashMap<>();

        // Build the transition map from allowed rules
        for (String al : allowed) {
            int a = al.charAt(0) - 'A';
            int b = al.charAt(1) - 'A';

            if (map[a][b] == null)
                map[a][b] = new ArrayList<>();

            map[a][b].add(al.charAt(2));
        }

        // Start DFS from the bottom row
        return dfs(bottom.toCharArray(), map, memo);
    }

    private boolean dfs(char[] row, List<Character>[][] map, Map<String, Boolean> memo) {
        int n = row.length;

        // Base case: successfully built pyramid to the top
        if (n == 1) return true;

        // Memoization key: current row as a string
        String key = new String(row);
        if (memo.containsKey(key))
            return memo.get(key);

        // Generate all possible rows above the current row
        List<char[]> nextRows = new ArrayList<>();
        getNextRows(row, map, 0, new char[n - 1], nextRows);

        // Try each possible next row
        for (char[] next : nextRows) {
            if (dfs(next, map, memo)) {
                memo.put(key, true);
                return true;
            }
        }

        // If no path works, mark as impossible
        memo.put(key, false);
        return false;
    }

    private void getNextRows(
            char[] row,
            List<Character>[][] map,
            int idx,
            char[] current,
            List<char[]> result) {

        // If we've built a full row above
        if (idx == row.length - 1) {
            result.add(current.clone());
            return;
        }

        // Get the pair (row[idx], row[idx+1])
        int a = row[idx] - 'A';
        int b = row[idx + 1] - 'A';

        // If no valid block can sit above this pair, prune
        if (map[a][b] == null) return;

        // Try all possible blocks that can sit on top
        for (char c : map[a][b]) {
            current[idx] = c;
            getNextRows(row, map, idx + 1, current, result);
        }
    }
}
