class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        /**
         * The HashMap will store with the key being any particular sum, and the value
         * being the number of times it has happened till the current iteration of the
         * loop as we traverse the array from left to right
         */
        Map<Integer, Integer> sumOccurrencesMap = new HashMap<>();
        sumOccurrencesMap.put(0, 1);
        for (int i : nums) {
            sum += i;
            if (sumOccurrencesMap.containsKey(sum - k)) {
                result += sumOccurrencesMap.get(sum - k);
            }
            sumOccurrencesMap.put(sum, sumOccurrencesMap.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}