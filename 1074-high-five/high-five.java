class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] i : items) {
            if(!map.containsKey(i[0])) {
                map.put(i[0], new ArrayList<>());
            }
            map.get(i[0]).add(i[1]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        map.forEach(
            (x, y) -> pq.offer(new int[]{x , calculateAverage(y)})
        );

        int[][] result = new int[pq.size()][2];
        int index = 0;
        while(!pq.isEmpty()) {
            result[index++] = pq.remove();
        }
        return result;
    }
    public int calculateAverage(List<Integer> scores) {
        int sum = 0;
        Collections.sort(scores, Collections.reverseOrder());
        for(int i = 0; i < scores.size(); i++) {
            sum += scores.get(i);
            if(i == 4) break;
        }

        return sum / 5;
    }
}