class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        int index = 0;
        for(int i:nums){
            if(map.get(i)==1)
                result[index++]=i;
        }

        return result;
        
    }
}