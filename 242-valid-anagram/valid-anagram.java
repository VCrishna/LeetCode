class Solution {
    // public boolean isAnagram(String s, String t) {
    //     Map<Character, Integer> sMap = new HashMap<>();
    //     Map<Character, Integer> tMap = new HashMap<>();
    //     for (char c : s.toCharArray())
    //         sMap.put(c, sMap.getOrDefault(c, 0) + 1);
    //     for (char c : t.toCharArray())
    //         tMap.put(c, tMap.getOrDefault(c, 0) + 1);
    //     return sMap.equals(tMap);
    // }

    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        // return new String(s1).equals(new String(t1));
        return Arrays.equals(s1,t1);
    }
}
