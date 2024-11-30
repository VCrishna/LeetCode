class Solution {
    public int[][] validArrangement(int[][] pairs) {
        int m = pairs.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        for (int[] pair : pairs) {
            int from = pair[0];
            int to = pair[1];
            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(to);
            degree.putIfAbsent(from, 0);
            degree.put(from, degree.get(from) - 1);
            degree.putIfAbsent(to, 0);
            degree.put(to, degree.get(to) + 1);
        }
        int start = -1;
        for (int key : degree.keySet()) {
            if (degree.get(key) == -1) {
                start = key;
                break;
            }
        }
        if (start == -1) {
            start = pairs[0][0];
        }
        List<Integer> path = new ArrayList<>();
        helper(path, start, map, degree);
        int[][] result = new int[m][2];
        for (int i = 0; i < path.size() - 1; i++) {
            result[i][0] = path.get(i);
            result[i][1] = path.get(i + 1);
        }
        return result;
    }

    private void helper(List<Integer> path, int start, Map<Integer, List<Integer>> map, Map<Integer, Integer> degree) {
        List<Integer> neighbors = map.get(start);
        while (neighbors != null && !neighbors.isEmpty()) {
            int next = neighbors.get(0);
            neighbors.remove(0);
            helper(path, next, map, degree);
        }
        path.add(0, start);
    }
}