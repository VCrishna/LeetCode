class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int minAbs = Integer.MAX_VALUE;

        // First pass: find minimum difference
        for (int i = 1; i < arr.length; i++) {
            minAbs = Math.min(minAbs, arr[i] - arr[i - 1]);
        }

        // Second pass: collect pairs with min difference
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minAbs) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}