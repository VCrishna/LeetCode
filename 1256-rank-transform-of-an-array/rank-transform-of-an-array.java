class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        Map<Integer,Integer> map = new HashMap<>();
        int k = 1;
        for(int i : sortedArr) {
            int val = map.getOrDefault(i,0);
            map.put(i, val == 0 ? k++ : val);
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}