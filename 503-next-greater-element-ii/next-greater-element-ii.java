class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Initializing the result array with -1 for each element
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        // Creating a stack to track indices of elements 
        // for which the next greater element is not found yet
        Stack<Integer> stack = new Stack();
        
        // Traversing the array twice to handle circular nature
        for (int i = 0; i < nums.length * 2; i++) {
            // Getting the actual element 
            // considering the circular nature of the array
            int num = nums[i % nums.length];
            
            // While the stack is not empty and the current element is 
            // greater than the element at the top of the stack
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                // Updating the result array with the next greater element 
                // for the element at the top of the stack
                result[stack.pop()] = num;
            }
            
            // If the current iteration is within the original array length, 
            // push the current index onto the stack
            if (i < nums.length) {
                stack.push(i);
            }
        }

        // Returning the modified result array containing 
        // the next greater element for each element in the input array
        return result;
    }
}
