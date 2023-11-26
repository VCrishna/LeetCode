class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 2];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min = Math.min(dp[j], dp[j + 1]);
                dp[j] = triangle.get(i).get(j) + min;
            }
        }

        return dp[0];
    }

    public int minimumTotal_brd(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        return triangle.get(0).get(0);
    }

    public int minimumTotal_BRUTE_FORCE(List<List<Integer>> triangle) {
        int result = triangle.get(0).get(0);
        int index = 0;

        for (int i = 1; i < triangle.size(); i++) {
            int min = Math.min(triangle.get(i).get(index), triangle.get(i).get(index + 1));
            index = triangle.get(i).indexOf(min);
            result += min;
        }
        return result;
    }
}
