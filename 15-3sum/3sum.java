class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // avoiding duplicates for first elemet
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int first = nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (first + sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // avoiding duplicates at left
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // avoiding duplicates at right
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        // regular increment of pointers
                        left++;
                        right--;
                    } else if (first + sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }

            }
        }
        return result;
    }
}