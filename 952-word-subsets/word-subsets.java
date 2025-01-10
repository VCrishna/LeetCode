class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        // Calculating the maximum frequency of each character required by words2
        Map<Character, Integer> maxFreq = new HashMap<>();
        for (String s : words2) {
            Map<Character, Integer> tempFreq = new HashMap<>();
            for (char ch : s.toCharArray()) {
                tempFreq.put(ch, tempFreq.getOrDefault(ch, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : tempFreq.entrySet()) {
                char ch = entry.getKey();
                int freq = entry.getValue();
                maxFreq.put(ch, Math.max(maxFreq.getOrDefault(ch, 0), freq));
            }
        }

        // Checking each word in words1 to see if it satisfies the universal condition
        for (String s : words1) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            boolean isUniversal = true;
            for (Map.Entry<Character, Integer> entry : maxFreq.entrySet()) {
                char ch = entry.getKey();
                int requiredFreq = entry.getValue();
                if (map.getOrDefault(ch, 0) < requiredFreq) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.add(s);
            }
        }

        return result;
    }
}
