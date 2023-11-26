class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int result = 0;
        int[] prevHeights = new int[columns];

        for (int r = 0; r < rows; r++) {
            int[] heights = matrix[r].clone();
            for (int c = 0; c < columns; c++) {
                if (heights[c] > 0) {
                    heights[c] += prevHeights[c];
                }
            }
            int[] sortedHeights = Arrays
                .stream(heights)
                .boxed() // Convert to Integer stream
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
            for (int i = 0; i < columns; i++) {
                result = Math.max(result, (i + 1) * sortedHeights[i]);
            }
            prevHeights = heights;
        }

        return result;
    }
}
