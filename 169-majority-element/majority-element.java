class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer majorityEle = null;

        for(int num : nums) {
            if(count == 0) {
                majorityEle = num;
            }
            count += (num == majorityEle) ? 1 : -1;
        }

        return majorityEle;
    }
    public int majorityElement_EXTRA_SPACE(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        for(int i : nums) {
            if(map.get(i) > nums.length / 2) return i;
        }
        return 0;
    }
}