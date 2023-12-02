class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> freqCount = new HashMap<>();
        for(char c : chars.toCharArray()) freqCount.put(c, freqCount.getOrDefault(c , 0) + 1);
        int result = 0;
        for(String word : words) {
            Map<Character, Integer> wordCount = new HashMap<>();
            for(char c : word.toCharArray()) wordCount.put(c, wordCount.getOrDefault(c , 0) + 1);
            // wordCount.forEach((x,y)->System.out.println(x+" "+y));
            boolean diff = true;
            for(char c : word.toCharArray()) {
                if(freqCount.containsKey(c) && wordCount.get(c) <= freqCount.get(c)) {
                    continue;
                }
                else
                    diff = false;
            }
            if(diff) {
                result += word.length();
            }
            
        }
        return result;
    }
}