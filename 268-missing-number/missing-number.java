class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for(int i : nums) {
            if(i == sum){
                sum++;
            }
            else{
                return sum;
            }
        }
        return sum;
    }
}