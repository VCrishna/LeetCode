/**
    When we see k = | A[i] | for the first time, multiply A[k] by -1. 
    The negative sign on index k indicates k has been seen once. 
    As you progress through the array, you will find some j > i such that A[j] = k. 
    Now when you look at A[k], it is already negative (seen once). Thus j is a duplicate.
        
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])  - 1;
            if(nums[index] < 0) {
                result.add(index + 1);
            }
            else
                nums[index] *= -1;
        }
        return result;
    }
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                result.add(index + 1);
            }
            nums[index] *= -1;
        }

        return result;
    }
}
