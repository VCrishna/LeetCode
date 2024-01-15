class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> players = new HashSet<>();
        Map<Integer, Integer> loserMap = new HashMap<>();
        for (int[] match : matches) {
            players.add(match[0]);
            players.add(match[1]);
            loserMap.put(match[1], loserMap.getOrDefault(match[1], 0) + 1);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int x : players) {
            if(!loserMap.containsKey(x)) {
                list1.add(x);
            }
            else if(loserMap.get(x) == 1) {
                list2.add(x);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        return Arrays.asList(list1, list2);
    }
}