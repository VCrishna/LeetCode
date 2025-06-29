class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int mod = (int) 1e9 + 7;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                result = (result + fastPower(2, right - left, mod)) % mod;
                left++;
            }
        }
        return result;
    }

    int fastPower(int a, int b, int mod) {
        long ans = 1;
        long base = a;
        while (b != 0) {
            if (b % 2 == 1) {
                ans = (ans * base) % mod;
            }
            base = (base * base) % mod;
            b /= 2;
        }
        return (int) ans;
    }
}