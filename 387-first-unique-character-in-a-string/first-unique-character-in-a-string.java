class Solution {
    public int firstUniqChar(String s) {

        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }

        // mp.entrySet().forEach(System.out::println);
        
        for(int i = 0; i < s.length(); i++) {
            if(mp.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        return -1;
    }
}