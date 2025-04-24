class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int result = 0;
        Set<Integer> distinctElements1 = new HashSet<>();
        for (int i : nums) {
            distinctElements1.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> distinctElements2 = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                distinctElements2.add(nums[j]);
                if (distinctElements1.size() == distinctElements2.size()) {
                    result += nums.length - j;
                    break;
                }
            }
        }
        return result;
    }
}