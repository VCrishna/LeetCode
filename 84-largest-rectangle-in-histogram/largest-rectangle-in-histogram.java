class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < heights.length; i++) {
            
            while (
                !stack.isEmpty() && stack.peek()[1] > heights[i]
            ) {
                int[] current = stack.pop();

                int width = i - (stack.isEmpty() ? 0 : stack.peek()[0] + 1);

                maxArea = Math.max(maxArea, current[1] * width);

            }

            stack.push(new int[]{i, heights[i]});
        }

        while (!stack.isEmpty()) {
                int[] current = stack.pop();

                int width = heights.length - (stack.isEmpty() ? 0 : stack.peek()[0] + 1);

                maxArea = Math.max(maxArea, current[1] * width);

            }

        return maxArea;
    }
}

































/** class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // Initialize maxArea to store the maximum rectangle area.
        int maxArea = 0;

        // Use a stack to store pairs of indices and heights.
        // This helps keep track of bars that can potentially form larger rectangles.
        Stack<int[]> stack = new Stack<>();

        // Iterate over each bar in the histogram.
        for (int i = 0; i < heights.length; i++) {
            // If the stack is non-empty and the current height is less than the
            // height of the bar at the top of the stack, 
            // then we need to compute potential rectangles.
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                // Pop the top bar from the stack since it can't be extended to the right anymore.
                int[] current = stack.pop();

                // Calculate the width of the potential rectangle.
                // If the stack is empty, it means current[1] was the shortest bar seen so far,
                // so use the entire width up to 'i'. 
                // Otherwise, the width is between the current bar and the next shortest bar.
                int width = i - (stack.isEmpty() ? 0 : stack.peek()[0] + 1);

                // Update maxArea if the area of the rectangle formed by the popped bar is larger.
                maxArea = Math.max(maxArea, current[1] * width);
            }

            // Push the current bar onto the stack. 
            // It may be part of a larger rectangle later on.
            stack.push(new int[] { i, heights[i] });
        }

        // Process any remaining bars in the stack. 
        // These bars didn't have any shorter bar to their right.
        while (!stack.isEmpty()) {
            // Pop the top bar.
            int[] current = stack.pop();

            // Calculate the width of the potential rectangle.
            // If the stack is empty, the rectangle extends till the end of the histogram.
            // Otherwise, it extends up to the bar just before the next shorter bar.
            int width = heights.length - (stack.isEmpty() ? 0 : stack.peek()[0] + 1);

            // Update maxArea if the area of the rectangle formed by the popped bar is larger.
            maxArea = Math.max(maxArea, current[1] * width);
        }

        // Return the largest rectangle area.
        return maxArea;
    }
}
*/
