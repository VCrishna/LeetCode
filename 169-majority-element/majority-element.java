class Solution {
    public int majorityElement(int[] nums) {
        int result = 0, count = 0;
        for(int i : nums) {
            if(count == 0)
                result = i;
            count += (i == result ? 1 : -1);
        }
        return result;
    }
    public int majorityElement_brute(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            myMap.put(num, myMap.getOrDefault(num, 0) + 1);
            if (myMap.get(num) > nums.length / 2)
                return num;
        }
        return 0;
    }
}
