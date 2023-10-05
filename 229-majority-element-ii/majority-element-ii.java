class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i,0)+1);
            if(map.get(i) > n / 3 && !result.contains(i)) 
                result.add(i);
        }
        return result;
    }
}