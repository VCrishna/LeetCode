class Solution {
    public int countNegatives(int[][] grid) {
        int result = 0;
        for (int[] i : grid) {
            for (int j : i) {
                if (j < 0) {
                    result += 1;
                }
            }
        }
        return result;
    }
}