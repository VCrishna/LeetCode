class Solution {

    public int findSpecialInteger(int[] arr) {
        int size = arr.length / 4;
        for(int i = 0; i < arr.length - size; i++) {
            if(arr[i] == arr[i + size]) return arr[i];
        }
        return 0;
    }

    public int findSpecialInteger_BRUTE_FORCE(int[] arr) {
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
