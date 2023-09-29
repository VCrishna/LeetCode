class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            map.putIfAbsent(groupSize, new ArrayList<>());
            map.get(groupSize).add(i);
            if(map.get(groupSize).size() == groupSize) {
                result.add(map.get(groupSize));
                map.put(groupSize,new ArrayList<>());
            }
        }
        return result;
    }
}
