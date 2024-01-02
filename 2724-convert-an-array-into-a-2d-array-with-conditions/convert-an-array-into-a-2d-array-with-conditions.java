class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // number and its frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            int row = map.get(i);
            // Ensuring that the result list has enough rows
            if(result.size() < row) {
                result.add(new ArrayList<>());
            }
            // Adding the number to the appropriate frequency group
            result.get(row - 1).add(i);
        }

        return result;
    }
}
