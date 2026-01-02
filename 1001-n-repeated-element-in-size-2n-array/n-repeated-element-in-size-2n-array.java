class Solution {
    public int repeatedNTimes(int[] nums) {
        int ret=0;
        List<Integer> k=new ArrayList<>();
        for(int i:nums){
            k.add(i);
        }
        for(Integer j:k){
            if(Collections.frequency(k,j)>=2){
                ret=j;
                return ret;
            }
        }  
        return ret;
    }
}