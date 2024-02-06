class SparseVector {
    Map<Integer, Integer> map;

    SparseVector(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;

        for(int i : map.keySet()) {
            if(vec.map.containsKey(i)) {
                result += vec.map.get(i) * map.get(i);
            }
        }

        return result;
    }
}

class SparseVector_BRUTE_FORCE {

    private int[] array;

    SparseVector_BRUTE_FORCE(int[] nums) {
        array = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector_BRUTE_FORCE vec) {
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            result += array[i] * vec.array[i];
        }
        return result;
    }
}
// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);