class Solution {

    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Populate the map with student IDs and their scores
        for (int[] i : items) {
            map.computeIfAbsent(i[0], k -> new ArrayList<>()).add(i[1]);
        }

        List<int[]> result = new ArrayList<>();

        // Calculate the average of the top 5 scores for each student
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int id = entry.getKey();
            List<Integer> scores = entry.getValue();

            // Sort the scores in descending order
            Collections.sort(scores, Collections.reverseOrder());

            // Calculate the sum of the top 5 scores
            int sum = 0;
            for (int i = 0; i < Math.min(5, scores.size()); i++) {
                sum += scores.get(i);
            }

            result.add(new int[] { id, sum / Math.min(5, scores.size()) });
        }

        // Sort the result based on student ID
        result.sort((a, b) -> a[0] - b[0]);

        return result.toArray(new int[result.size()][2]);
    }

    public int[][] highFive_MY_APPROACH(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] i : items) {
            if (!map.containsKey(i[0])) {
                map.put(i[0], new ArrayList<>());
            }
            map.get(i[0]).add(i[1]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        map.forEach((x, y) -> pq.offer(new int[] { x, calculateAverage(y) }));

        int[][] result = new int[pq.size()][2];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.remove();
        }
        return result;
    }

    public int calculateAverage(List<Integer> scores) {
        int sum = 0;
        Collections.sort(scores, Collections.reverseOrder());
        for (int i = 0; i < scores.size(); i++) {
            sum += scores.get(i);
            if (i == 4) break;
        }

        return sum / 5;
    }
}
