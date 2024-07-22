class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String[] result = new String[names.length];

        TreeMap<Integer, String> map = new TreeMap<>((a, b) -> (b - a));

        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        int index = 0;
        for (String name : map.values()) {
            result[index++] = name;
        }

        return result;
    }
}