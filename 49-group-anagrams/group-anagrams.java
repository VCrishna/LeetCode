class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            map.computeIfAbsent(new String(c), k -> new ArrayList<>());
            map.get(new String(c)).add(s);
        }

        return new ArrayList<>(map.values());
    }
}