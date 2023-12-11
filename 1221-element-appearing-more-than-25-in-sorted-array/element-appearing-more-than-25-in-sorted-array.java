class Solution {

    public int findSpecialInteger(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = arr.length;
        int result = 0;
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) >= 0.25 * length) result = i;
        }
        return result;
    }
}
