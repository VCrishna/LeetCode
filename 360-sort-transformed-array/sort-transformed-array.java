/**
        the problem seems to have many cases a>0, a=0,a<0, (when a=0, b>0, b<0). 
        However, they can be combined into just 2 cases: a>0 or a<0

        1.a>0, two ends in original array are bigger than center if you learned middle school math before.

        2.a<0, center is bigger than two ends.

        so use two pointers i, j and do a merge-sort like process. 
        depending on sign of a, you may want to start from the beginning or end of the transformed array. 
        For a==0 case, it does not matter what b's sign is.
    
        The function is monotonically increasing or decreasing. you can start with either beginning or end.
*/
class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = a >= 0 ? nums.length - 1 : 0;
        while (left <= right) {
            if (a >= 0) {
                result[index--] = quad(nums[left], a, b, c) >= quad(nums[right], a, b, c) ? quad(nums[left++], a, b, c) : quad(nums[right--], a, b, c);
            } else {
                result[index++] = quad(nums[left], a, b, c) >= quad(nums[right], a, b, c) ? quad(nums[right--], a, b, c) : quad(nums[left++], a, b, c);
            }
        }
        return result;
    }

    private int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    public int[] sortTransformedArray_BRUTE_FORCE(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = a * nums[i] * nums[i] + b * nums[i] + c;
        }
        Arrays.sort(result);

        return result;
    }
}
