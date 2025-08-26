class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int result = -1; // best rectangle area so far
        double maxDiagLength = -1; // longest diagonal found so far
        for (int[] rec : dimensions) {
            int width = rec[0], height = rec[1];
            double diagLength = Math.sqrt(width * width + height * height); // Pythagoras
            int area = width * height;

            // Update if we found a longer diagonal
            // Or if diagonal is same but area is larger
            if (diagLength > maxDiagLength ||
                    (diagLength == maxDiagLength && area > result)) {
                result = area;
                maxDiagLength = diagLength;
            }
        }

        return result;
    }
}