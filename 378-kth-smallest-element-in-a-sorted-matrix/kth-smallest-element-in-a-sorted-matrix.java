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
     int n = matrix.length;
      int low = matrix[0][0];
      int high = matrix[n - 1][n - 1];
      
      while(low < high) {
        int mid = low + (high - low) / 2;
        int count = lessEqual(matrix, mid);
        
        if(count < k) low = mid + 1;
        else
          high = mid;
      }
      return low;
    }
  public int lessEqual(int[][] matrix, int target) {
    int count = 0, len = matrix.length;
    int i = len - 1, j = 0;
    
    while(i >= 0 && j < len) {
      if(matrix[i][j] > target) i --;
      
      else{
        count = count + i + 1;
        j ++;
      }
      
    }
      return count;
  }
}

*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // for(int[] row : matrix) {
        //     for(int col : row) {
        //         maxHeap.add(col);
        //         if(maxHeap.size() > k)
        //             maxHeap.poll();
        //     }
        // }
        // return maxHeap.poll();
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n-1][n-1];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0, j = n - 1;
            
            for (int i = 0; i < n; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += j + 1;
            }
            
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
