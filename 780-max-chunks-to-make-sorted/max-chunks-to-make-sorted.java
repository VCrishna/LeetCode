class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunk = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (i == max) {
                chunk++;
            }
        }
        return chunk;
    }
}