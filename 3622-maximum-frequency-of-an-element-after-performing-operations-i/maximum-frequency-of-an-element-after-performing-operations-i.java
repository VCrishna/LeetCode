class Solution {
    public int maxFrequency(int[] nums, int k, int numOps) {
        int maxVal = Arrays.stream(nums).max().getAsInt() + k + 2;
        int[] count = new int[maxVal];

        // Count occurrences of each number
        for (int v : nums)
            count[v]++;

        // Prefix sum: count[i] = total elements ≤ i
        for (int i = 1; i < maxVal; i++)
            count[i] += count[i - 1];

        int res = 0;
        for (int i = 0; i < maxVal; i++) {
            int left = Math.max(0, i - k);
            int right = Math.min(maxVal - 1, i + k);
            int total = count[right] - (left > 0 ? count[left - 1] : 0); // numbers in [i-k, i+k]
            int freq = count[i] - (i > 0 ? count[i - 1] : 0); // count of i
            res = Math.max(res, freq + Math.min(numOps, total - freq));
        }

        return res;
    }
}
