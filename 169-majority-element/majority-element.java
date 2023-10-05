class Solution {
    // The Boyer-Moore Majority Vote Algorithm
    public int majorityElement(int[] nums) {
        // 'result' will hold the current candidate for majority element.
        int result = 0;
        
        // 'count' is a counter for the majority element.
        int count = 0;

        // Iterate through each number in the 'nums' array.
        for(int i : nums) {
            // If count is zero, then set 'i' as the new candidate for majority element.
            if(count == 0)
                result = i;

            // Increment the counter if the current number is the same as the current majority candidate, 
            // otherwise decrement it.
            count += (i == result ? 1 : -1);
        }

        // After iterating through all numbers, 'result' will have the majority element.
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
