class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Base case: for different length of two strings
        if(s.length() != t.length())
            return false; 
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(Integer i = 0; i <s.length(); i ++) {
            // Compare two maps, if not equal, return false
            if(map1.put(s.charAt(i), i) != map2.put(t.charAt(i), i)){
                return false;
            }
        }
        return true;
    }
}