class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> group = new ArrayList<>();

        if(strs == null || strs.length == 0) return group;

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] sCharArray = s.toCharArray();
            Arrays.sort(sCharArray);
            String s2 = new String(sCharArray);
            if(!map.containsKey(s2))
                map.put(s2, new ArrayList<>());
            
            map.get(s2).add(s);
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            group.add(entry.getValue());
        }

        return group;
    }
}