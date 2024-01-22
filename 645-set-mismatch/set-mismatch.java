public class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicateNumber = -1, missingNumber = 1;
        for (int n: nums) {
            if (nums[Math.abs(n) - 1] < 0)
                duplicateNumber = Math.abs(n);
            else
                nums[Math.abs(n) - 1] *= -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                missingNumber = i + 1;
        }
        return new int[]{duplicateNumber, missingNumber};
    }
    public int[] findErrorNums_MAP(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int duplicate = -1, missingNumber = 1;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2)
                    duplicate = i;
            } else
                missingNumber = i;
        }
        return new int[] { duplicate, missingNumber };
    }
}