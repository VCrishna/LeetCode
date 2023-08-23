class Solution {

    public String reorganizeString(String s) {
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }
        // charFreqMap.forEach((x,y) -> System.out.println(x+" "+y));
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charFreqMap.get(b) - charFreqMap.get(a));
        maxHeap.addAll(charFreqMap.keySet());

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 1) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();
            sb.append(first);
            sb.append(second);
            charFreqMap.put(first, charFreqMap.get(first) - 1);
            charFreqMap.put(second, charFreqMap.get(second) - 1);
            if(charFreqMap.get(first) > 0) {
                maxHeap.offer(first);
            }
            if(charFreqMap.get(second) > 0) {
                maxHeap.offer(second);
            }
        }

        if(!maxHeap.isEmpty()) {
            if(charFreqMap.get(maxHeap.peek()) > 1) {
                return "";
            }
            else {
                sb.append(maxHeap.poll());
            }
        }

        return sb.toString();
    }
}
