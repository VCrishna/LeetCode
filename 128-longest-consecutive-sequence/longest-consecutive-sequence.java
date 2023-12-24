class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int longest = 0;

        Set<Integer> set = new HashSet<>();

        for (int i : nums) set.add(i);

        for (int n : nums) {
            int length = 0;
            // check if it is the start of a sequence
            if (!set.contains(n - 1)) {
                while (set.contains(n + length)) {
                    length++;
                }
            }
            longest = Math.max(longest, length);
        }

        return longest;
    }
}
