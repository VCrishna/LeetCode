class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for(int i : nums) {
            if(i == target)
                count++;
        }
        return count > nums.length / 2;
    }
    public boolean isMajorityElement_MY_APPROACH(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums) map.put(i, map.getOrDefault(i,0)+1);

        return map.containsKey(target) ? map.get(target) > (nums.length) / 2 : false;
        
    }
}