class Solution {
    public int[][] divideArray(int[] nums, int k) {
        if (nums.length % 3 != 0) {
            return new int[0][0];
        }
        int[][] result = new int[nums.length / 3][3];
        List<int[]> lst = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 1] - nums[i] <= k && nums[i + 2] - nums[i] <= k) {
                lst.add(new int[] { nums[i], nums[i + 1], nums[i + 2] });
            } else {
                return new int[0][0];
            }
        }
        int index = 0;
        for(int[] i : lst) {
            result[index++] = i;
        }
        return result;
    }
}