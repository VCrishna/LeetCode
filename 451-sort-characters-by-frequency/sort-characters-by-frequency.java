class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char k : s.toCharArray()) {
            freqMap.put(k, freqMap.getOrDefault(k, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(freqMap.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            // System.out.println(pq.poll());
            Map.Entry<Character, Integer> entry = pq.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey()+"");
            }
        }
        return sb.toString();
    }
}
