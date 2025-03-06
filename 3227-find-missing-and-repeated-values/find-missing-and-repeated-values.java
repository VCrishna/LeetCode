class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        if (grid == null || grid.length == 0)
            return result;
        Map<Integer, Integer> map = new HashMap<>();
        int len = grid[0].length;
        for (int i = 1; i <= len * len; i++) {
            map.put(i, 0);
        }
        for (int[] i : grid) {
            for (int j : i) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }

        for (int i : map.keySet()) {
            if (map.get(i) == 0) {
                result[1] = i;
            } else if (map.get(i) > 1) {
                result[0] = i;
            }
        }

        return result;
    }
}