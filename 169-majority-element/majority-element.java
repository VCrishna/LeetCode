class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            myMap.put(num, myMap.getOrDefault(num, 0) + 1);
            if (myMap.get(num) > nums.length / 2)
                return num;
        }
        return 0;
    }
}
