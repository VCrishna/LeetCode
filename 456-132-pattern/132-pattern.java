class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3)
            return false;
        // int i = 0, j = 1, k = 2;
        // while(k < nums.length) {
        //     if(nums[i] < nums[k] && nums[k] < nums[j]) 
        //         return true;
        //     i++;
        //     j++;
        //     k++;
        // }
        int length = nums.length;
        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i = length - 1; i >= 0; i--) {
            if(nums[i] < third)
                return true;
            
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                third = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;

    }
}