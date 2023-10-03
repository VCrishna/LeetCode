class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        int deletions = 0;

        // calculating the frequencies of each character
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i : map.values()) {
            
            while(i > 0 && set.contains(i)){
                i--;
                deletions++;
            }
            set.add(i);
        }
        return deletions;
    }
}
