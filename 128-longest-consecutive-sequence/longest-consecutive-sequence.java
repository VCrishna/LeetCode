class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int maxSequence = 0;

        Set<Integer> set = new HashSet<>();

        for (int i : nums) set.add(i);

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int currentSequence = 1;
            // checking the set if we have the smallest number
            // else we are not looping through the set
            if (!set.contains(currentNumber - 1)) {
                while (set.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentSequence++;
                }
                maxSequence = Math.max(maxSequence, currentSequence);
            }
        }

        return maxSequence;
    }
}