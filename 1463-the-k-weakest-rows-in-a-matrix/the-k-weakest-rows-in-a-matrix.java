class Pair {
    int count;
    int rowIndex;

    Pair(int ri, int c) {
        this.count = c;
        this.rowIndex = ri;
    }
}

class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((p1, p2) -> p1.count != p2.count ? p1.count - p2.count : p1.rowIndex - p2.rowIndex);

        for (int i = 0; i < mat.length; i++) {
            minHeap.add(new Pair(i, countOnes(mat[i])));
        }
        // while (!minHeap.isEmpty()) {
        //     System.out.println(minHeap.poll().rowIndex);
        // }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().rowIndex;
        }
        return result;
    }

    public int countOnes(int[] row) {
        int left = 0;
        int right = row.length;
        while (left < right) {
            int middleIndex = left + (right - left) / 2;
            if (row[middleIndex] == 1) {
                left = middleIndex + 1;
            } else {
                right = middleIndex;
            }
        }
        return left;
    }
}
