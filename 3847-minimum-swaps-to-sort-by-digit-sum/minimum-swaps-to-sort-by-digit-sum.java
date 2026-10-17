class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length, ret = 0;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            int sum = 0, num = nums[i];
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            arr[i] = ((long) sum) << 47 | ((long) nums[i] << 17) | i;
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                int next = (int) (arr[i] & 0x1FFFFL);
                arr[i] = -1;
                while (arr[next] >= 0) {
                    int temp = (int) (arr[next] & 0x1FFFFL);
                    arr[next] = -1;
                    next = temp;
                    ret++;
                }
            }
        }
        return ret;
    }
}