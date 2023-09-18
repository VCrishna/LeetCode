class Pair{
    // variable used to store index of row
    int index;
    // variable used to store count of 1's in the row
    int count;
    Pair(int a,int b){
        this.index = a;
        this.count = b;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // defining PriorityQueue
        // PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
        //     if (p1.count != p2.count) {
        //         return p1.count - p2.count; // Sort by count in ascending order
        //     } else {
        //         return p1.index - p2.index; // Maintain original order for rows with the same count
        //     }
        // });
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (p1, p2) -> p1.count != p2.count ? p1.count - p2.count : p1.index - p2.index
            );

        // filling PriorityQueue with index of rows and number of ones present in each row
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new Pair(i,countOnes(mat[i])));
        }
        
        int[] result = new int[k];

        for(int i = 0;i<k;i++)
            result[i]=pq.poll().index;
    
        return result;
    }
    // binary search to find total number of ones present in each row
    private int countOnes(int[] row) {
        int lo = 0;
        int hi = row.length;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }
        
        return lo;
    }
}