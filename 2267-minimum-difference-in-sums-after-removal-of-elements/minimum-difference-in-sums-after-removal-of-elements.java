class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;

        // Max heap for left segment to track largest elements (to discard)
        PriorityQueue<Integer> maxHeapLeft = new PriorityQueue<>(Collections.reverseOrder());

        // Min heap for right segment to track smallest elements (to discard)
        PriorityQueue<Integer> minHeapRight = new PriorityQueue<>();

        long[] minLeftSums = new long[n + 1]; // Stores min possible sums from left
        long[] maxRightSums = new long[n + 1]; // Stores max possible sums from right

        // Compute min possible sum of any n elements from the first 2n elements
        long leftSum = 0;
        for (int i = 0; i < 2 * n; i++) {
            leftSum += nums[i];
            maxHeapLeft.add(nums[i]);

            // Once heap has more than n elements, remove largest (we want smallest n elements)
            if (i >= n) {
                leftSum -= maxHeapLeft.poll();
            }

            // Store sum of smallest n elements from nums[0..i]
            if (i >= n - 1) {
                minLeftSums[i - n + 1] = leftSum;
            }
        }

        // Compute max possible sum of any n elements from the last 2n elements
        long rightSum = 0;
        for (int i = 3 * n - 1; i >= n; i--) {
            rightSum += nums[i];
            minHeapRight.add(nums[i]);

            // Once heap has more than n elements, remove smallest (we want largest n elements)
            if (i < 2 * n) {
                rightSum -= minHeapRight.poll();
            }

            // Store sum of largest n elements from nums[i..end]
            if (i <= 2 * n) {
                maxRightSums[2 * n - i] = rightSum;
            }
        }

        // Calculate minimal difference between left and right
        long minDiff = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            long diff = minLeftSums[i] - maxRightSums[n - i];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}