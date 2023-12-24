class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        int longestSequence = 0;
        for (int i : nums) {
            int currentSequence = i;
            int sequence = 0;
            // checking if this is the starting of the sequence
            if (!set.contains(currentSequence - 1)) {
                while (set.contains(currentSequence + sequence)) {
                    sequence++;
                }
            }
            longestSequence = Math.max(sequence, longestSequence);
        }
        return longestSequence;
    }
}
