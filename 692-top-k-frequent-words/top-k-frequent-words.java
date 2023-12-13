class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
        PriorityQueue<String> maxHeap = new PriorityQueue<>(
            (a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a)
        );
        for (String s : map.keySet()) maxHeap.add(s);
        List<String> result = new ArrayList<>();
        while (k > 0) {
            result.add(maxHeap.remove());
            k--;
        }
        return result;
    }

    public List<String> topKFrequent_BRUTE_FORCE(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
        List<String> result = new ArrayList<>(map.keySet());
        Collections.sort(result, (a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a));
        return result.subList(0, k);
    }
}
