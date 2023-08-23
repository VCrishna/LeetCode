class Solution {
    public String reorganizeString(String s) {
        // Character Frequency Map used to maintain characters and frequency of characters present in the given string
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        // updating the charFreqMap with count of occurance of each character present in the given string
        for (char ch : s.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }
        // charFreqMap.forEach((x,y) -> System.out.println(x+" "+y));
        // Priority Queue -- Max Heap -> Characters are stored in decreasing order in Priority Queue
        // Most frequent occured element will be stored at the top of the queue
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charFreqMap.get(b) - charFreqMap.get(a));
        
        // adding the char of charFreqMap into the maxheap with sorting the frequencies by large->small
        maxHeap.addAll(charFreqMap.keySet());
        // now maxheap has the most frequent character on the top
        
        // obtain the character 2 by 2 from the maxheap to put in the result sb
        // until there is only one element(character) left in the maxheap
        // create a stringbuilder to build the result result
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 1) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();
            sb.append(first);
            sb.append(second);
            // Decrease the frequency of used character in the charFreqMap
            charFreqMap.put(first, charFreqMap.get(first) - 1);
            charFreqMap.put(second, charFreqMap.get(second) - 1);

            // insert the character back to the freq_map if the count in
            // hashmap of these two character are still > 0
            if(charFreqMap.get(first) > 0) {
                maxHeap.offer(first);
            }
            if(charFreqMap.get(second) > 0) {
                maxHeap.offer(second);
            }
        }
        if(!maxHeap.isEmpty()) {
            // when there is only 1 element left in the maxheap
            // check the count, it should not be greater than 1
            // otherwise it would be impossible and should return ""
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
