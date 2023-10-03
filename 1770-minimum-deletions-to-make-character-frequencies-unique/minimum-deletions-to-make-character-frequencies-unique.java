class Solution {
    public int minDeletions(String s) {
        // count number of deletions
        int deletions = 0;
        // frequencies array is used to store frequency of each character
        int[] frequencies = new int[26]; // 26 --> alphabets
        // set is used to maintain used characters
        Set<Integer> used = new HashSet<>();
        // count frequencies of each character and updating in frequencies array
        for(char ch : s.toCharArray()) {
            frequencies[ch-'a']++;
        }
        // iterating over each frequency
        for(int i : frequencies){
            // System.out.println(i);
            // if current frequncy of a character is > 0 &&  !used.add(frequency)
            // then we are decrementing frequency and incrementing number of deletions
            while(i > 0 && !used.add(i)) {
                i--;
                deletions++;
            }
        }

        return deletions;
    }
    public int minDeletions_with_map(String s) {
        // Map is used to store character and its frequency
        Map<Character, Integer> map = new HashMap<>();
        // set is used to maintain the unique frequncies of each character
        Set<Integer> set = new HashSet<>();
        // count number of deletions
        int deletions = 0;
        // calculating the frequencies of each character
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // iterating over the values in the map
        for(int i : map.values()) {
            // if current frequncy of a character is > 0 && it is present in the set
            // then we are decrementing it and increasing the count of deletions until the 
            // frequency is not present in the set
            // once we encounter a new frequency, we break this while loop and add it to the set
            while(i > 0 && set.contains(i)){
                i--;
                deletions++;
            }
            set.add(i);
        }
        return deletions;
    }
}
