class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Creating a map to store the next greater element for each element in nums2
        Map<Integer, Integer> map = new HashMap<>();

        // Creating a stack to track elements in nums2 for which the next greater
        // element is not found yet
        Stack<Integer> stack = new Stack();

        // Iterating through each element in nums2
        for (int i : nums2) {
            // While the stack is not empty and the current element is greater than the
            // element at the top of the stack
            while (!stack.isEmpty() && stack.peek() < i) {
                // Updating the map with the next greater element 
                // for the element at the top of the stack
                map.put(stack.pop(), i);
            }

            // Pushing the current element onto the stack
            stack.push(i);
        }

        // Iterating through each element in nums1
        for (int i = 0; i < nums1.length; i++) {
            // Updating each element in nums1 with its corresponding next greater element from the map
            // If the element has no next greater element, set it to -1
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        // Return the modified nums1 array
        return nums1;
    }
}
