class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int max_len = 0;

        for (int i = 0; i < n; i++) {

            int dist_even = 0, dist_odd = 0;

            // Track distinct values only for this starting index
            java.util.HashSet<Integer> even = new java.util.HashSet<>();
            java.util.HashSet<Integer> odd  = new java.util.HashSet<>();

            for (int j = i; j < n; j++) {
                int num = nums[j];

                if ((num & 1) == 0) {
                    if (even.add(num)) {
                        dist_even++;
                    }
                } else {
                    if (odd.add(num)) {
                        dist_odd++;
                    }
                }

                if (dist_even == dist_odd) {
                    max_len = Math.max(max_len, j - i + 1);
                }
            }
        }

        return max_len;
    }
}
