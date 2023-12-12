class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i : nums) {
            if(i > max1) {
                max2 = max1;
                max1 = i;
            }
            else if (i > max2) {
                max2 = i;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
    public int maxProduct_BRUTE_FORCE(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]-1)*(nums[j]-1)>max)
                    max=(nums[i]-1)*(nums[j]-1);
            }
        }
        return max;
    }
}
