class Solution {
    boolean[] visited;
    public int arrayNesting(int[] nums) {
        int length = Integer.MIN_VALUE;
        visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        for (int i = 0; i < nums.length; i++) {
            if (visited[nums[i]]) continue; else {
                Set<Integer> s = buildSet(nums, i, new HashSet<>());
                length = Math.max(length, s.size());
            }
        }
        return length;
    }

    public Set<Integer> buildSet(int[] nums, int index, Set<Integer> set) {
        if (set.contains(nums[index])) return set; else {
            set.add(nums[index]);
            visited[nums[index]] = true;
            return buildSet(nums, nums[index], set);
        }
    }
}
// [5,4,0,3,1,6,2]
// n = 7
// [0, 6]
