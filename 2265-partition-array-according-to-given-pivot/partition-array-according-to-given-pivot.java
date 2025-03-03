class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        for (int i : nums) {
            if (i < pivot)
                small.add(i);
            else if (i > pivot)
                large.add(i);
            else
                equal.add(i);
        }
        int index = 0;
        for (int i : small) {
            result[index++] = i;
        }
        for (int i : equal) {
            result[index++] = i;
        }
        for (int i : large) {
            result[index++] = i;
        }

        return result;
    }
}