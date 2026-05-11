class Solution {
    public int[] separateDigits(int[] nums) {
        int total = 0;

        for (int num : nums) {

            while (num > 0) {
                total++;
                num /= 10;
            }
        }

        int[] rez = new int[total];
        total -= 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            while (num != 0) {
                rez[total--] = num % 10;
                num /= 10;
            }
        }

        return rez;
    }
}