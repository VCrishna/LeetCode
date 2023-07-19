class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Iterate through the input array
        for (int i : nums) {
            int index = Math.abs(i);
            // Mark the presence of each number by flipping the sign of the corresponding index
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        // After the first pass, the indices that still have positive values are the missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        
        return res;
    }
}