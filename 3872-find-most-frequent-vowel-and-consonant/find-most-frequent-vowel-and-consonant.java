class Solution {
    public int maxFreqSum(String s) {
        int vowelFreq = 0, consonantFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        String vowels = "aeiou";

        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s.toCharArray()) {
            if(vowels.contains(ch+"")) {
                vowelFreq = Math.max(vowelFreq,freqMap.get(ch));
            }
            else {
                consonantFreq = Math.max(consonantFreq,freqMap.get(ch));
            }
        }

        return vowelFreq + consonantFreq;
    }
}