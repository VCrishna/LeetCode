class NumArray {
    int[] NumArray;
    public NumArray(int[] nums) {
        for(int i = 1; i<nums.length; i++){
            nums[i] = nums[i-1] +nums[i];
        }
        this.NumArray = nums;
    }
    
    public int sumRange(int left, int right) {
        if(left == 0)
            return NumArray[right];
        return NumArray[right] - NumArray[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */