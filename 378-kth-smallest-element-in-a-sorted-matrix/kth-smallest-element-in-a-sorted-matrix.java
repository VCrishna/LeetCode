/**
 Approach 1 (Using Sorting) //it is the first approach that usually comes into mind
 Time complexity : N * log(N);  //N == n^2
 Auxiliary space complexity: O(N)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int [] arr = new int[n*n];
        int idx = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                arr[idx++] = matrix[i][j];
            }
        }
        
        Arrays.sort(arr);
        
        return arr[k - 1];
    }
}
-------------------------------------------------------------------------------------------
Approach 2 (Using Priority Queue) // By reading that we have to return kth of something,
                                     this approach usually comes into mind
Time Complexity: N * log(K) //N== n^2
Auxiliary Space Complexity: O(K)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = matrix.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(pq.size() < k){
                    pq.add(matrix[i][j]);
                }else{ //equal to k
                    if(matrix[i][j] < pq.peek()){ //if incoming element is less than peek
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        return pq.peek();
    }
}
-------------------------------------------------------------------------------------------
Approach 3: Binary Search

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
    // Get the number of rows/columns (since it's an n x n matrix).
    int n = matrix.length;
    
    // Set initial values of left and right for binary search.
    // Left is set to the top-left corner value and right to the bottom-right corner value of the matrix.
    int left = matrix[0][0], right = matrix[n-1][n-1];
    
    // Binary search loop.
    while (left < right) {
        // Compute the middle value between left and right.
        int mid = left + (right - left) / 2;
        
        // Initialize count (to count numbers <= mid) and j (to traverse columns in reverse).
        int count = 0, j = n - 1;
        
        // Traverse the matrix row by row.
        for (int i = 0; i < n; i++) {
            // Move column pointer j to the left while the current value is greater than mid.
            while (j >= 0 && matrix[i][j] > mid) {
                j--;
            }
            
            // j + 1 gives the count of numbers <= mid in the current row.
            count += j + 1;
        }
        
        // If we've found less numbers than k, move left to mid + 1.
        if (count < k) {
            left = mid + 1;
        } else {
            // Else, move right to mid.
            right = mid;
        }
    }
    
    // When left and right converge, it's the kth smallest value.
    return left;
    }
}

*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int[] row : matrix) {
            for(int col : row) {
                maxHeap.add(col);
                if(maxHeap.size() > k)
                    maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}
