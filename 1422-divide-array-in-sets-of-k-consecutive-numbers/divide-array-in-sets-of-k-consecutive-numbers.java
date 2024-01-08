class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while(map.size() > 0) {
            int val = map.firstKey();
            for(int i = val; i < val + k; i++) {
                if(!map.containsKey(i)) {
                    return false;
                }
                map.put(i, map.getOrDefault(i, 0) - 1);
                if(map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }

        return true;
    }
}