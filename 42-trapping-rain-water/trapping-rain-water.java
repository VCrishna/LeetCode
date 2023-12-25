class Solution {
    // min(leftMax, rightMax) - height[i]
    public int trap(int[] height) {
        int trap = 0;
        
        int[] leftMax = new int[height.length];
        leftMax[0] = 0;
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = 0;

        for (int i = 1; i <= height.length - 1; i++) {
            leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
        }
        for (int i = height.length - 2; i >= 0 ; i--) {
            rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
        }

        // System.out.println(Arrays.toString(rightMax));

        for (int i = 0; i < height.length; i++) {
            int sum = Math.min(leftMax[i], rightMax[i]) - height[i];
            trap += sum > 0 ? sum : 0;
        }

        return trap;
    }
}
