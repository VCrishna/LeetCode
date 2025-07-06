class FindSumPairs {
    Map<Integer, Integer> map;
    int[] nums1;
    int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        map = new HashMap<>();
        this.nums1 = nums1;
        this.nums2 = nums2;
        // Building frequency map for nums2
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        // get current count
        // increment it in nums2
        // decrease prev value in map
        // increase current sum value in map
        // Update frequency map before modifying nums2[index]
        int oldVal = nums2[index];
        map.put(oldVal, map.get(oldVal) - 1);

        if (map.get(oldVal) == 0) {
            map.remove(oldVal);
        }

        // Updating nums2 value
        nums2[index] += val;

        // Adding new value to the frequency map
        int newVal = nums2[index];
        map.put(newVal, map.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        // For each element in nums1, checking for complements in nums2
        for (int num : nums1) {
            int complement = tot - num;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */