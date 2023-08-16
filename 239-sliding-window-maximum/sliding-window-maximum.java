class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 1) return nums;
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0;
        int right = 0;
        int length = nums.length;
        int index = 0;
        while (right < length) {
            // Expanding the window
            while(!deque.isEmpty() && deque.peekLast() < nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(nums[right]);
            // Shrinking the window
            if(k <= right - left + 1) {
                // update max value in result i.e., first element in the Deque
                result[index++] = deque.peekFirst();
                // update the deque
                // as we are shrinking the window if the element at the left index or 
                // the element which is going to be removed from the window is the first element
                // then we are going to remove that element from the deque
                if(nums[left++] == deque.peekFirst()) {
                    deque.pollFirst();
                }
            }
            right++;
        }
        return result;
    }
}


// Brute Foce --> TLE Time Complexity -> O(n * k)
// public int[] maxSlidingWindow(int[] nums, int k) {
//     if(nums.length == 1) return nums;
//     int[] result = new int[nums.length - k + 1];
//     for (int i = 0; i <= nums.length - k; i++) {
//         int max = nums[i];
//         for(int j = i; j < i + k; j++) {
//             max = Math.max(nums[j],max);
//         }
//         result[i] = max;
//     }
//     return result;
// }