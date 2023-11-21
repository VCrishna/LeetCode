class Solution {
    // 0 <= i < j < nums.length
    // nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
    // nums[i] - rev(nums[i]) == nums[j] j rev(nums[j])
    public int countNicePairs(int[] nums) {
        int MOD = (int) 1e9 + 7;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = nums[i] - rev(nums[i]);
            if (map.containsKey(difference)) {
                result = (result + map.get(difference)) % MOD;
            }
            map.put(difference, map.getOrDefault(difference, 0) + 1);
        }
        return result % MOD;
    }

    public int rev(int n) {
        // return Integer.parseInt(new StringBuilder(Integer.toString(n)).reverse().toString());
        int reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        return reverse;
    }
}
