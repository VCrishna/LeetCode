class Solution {
    public int maxArea(int[] height) {
        // variable to store max area
        int maxArea = 0;
        // left pointer
        int left = 0;
        // right pointer
        int right = height.length - 1;

        while(left < right) {
            // calculate width -> right - left
            int width = right - left;
            // we need to find min height from left and right, which means upto that height
            // our container can hold water
            int minHeight = Math.min(height[left], height[right]);
            // area = length * width
            maxArea = Math.max(maxArea, minHeight * width);
            // if left height is smaller than right move left pointer
            if(height[left] < height[right]) {
                left++;
            }
            // else shift right pointer
            else {
                right--;
            }
        }

        return maxArea;
    }
}