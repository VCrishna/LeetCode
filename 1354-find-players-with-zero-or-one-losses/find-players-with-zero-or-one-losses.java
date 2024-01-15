class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> players = new HashSet<>();
        TreeMap<Integer, Integer> winnerMap = new TreeMap<>();
        TreeMap<Integer, Integer> loserMap = new TreeMap<>();
        for (int[] match : matches) {
            players.add(match[0]);
            players.add(match[1]);
            winnerMap.put(match[0], winnerMap.getOrDefault(match[0], 0) + 1);
            loserMap.put(match[1], loserMap.getOrDefault(match[1], 0) + 1);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int x : players) {
            if(!loserMap.containsKey(x) && winnerMap.get(x) > 0) {
                list1.add(x);
            }
            else if(loserMap.get(x) == 1) {
                list2.add(x);
            }
        }
        // winnerMap.forEach((x, y) -> System.out.println(x + " " + y));
        // loserMap.forEach((x, y) -> System.out.println(x + " " + y));
        Collections.sort(list1);
        Collections.sort(list2);
        return Arrays.asList(list1, list2);
    }
}
// [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]