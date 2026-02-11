class SegmentTree {

    public int length;          // size of array
    public int treeSize;        // internal tree size (4 * n)
    public int[] totalSum;      // sum of segment
    public int[] minPrefix;     // minimum prefix sum in segment
    public int[] maxPrefix;     // maximum prefix sum in segment

    SegmentTree(int n) {
        this.length = n;
        this.treeSize = 4 * n;

        this.totalSum = new int[treeSize];
        this.minPrefix = new int[treeSize];
        this.maxPrefix = new int[treeSize];
    }

    /*
        Merge two child segments into parent.

        Key idea:
        - totalSum = leftSum + rightSum
        - minPrefix = minimum prefix in:
              left child OR
              (full left sum + right child prefix)
        - maxPrefix similarly
    */
    void pull(int node) {
        int leftChild = node * 2;
        int rightChild = node * 2 + 1;

        totalSum[node] = totalSum[leftChild] + totalSum[rightChild];

        minPrefix[node] = Math.min(
                minPrefix[leftChild],
                totalSum[leftChild] + minPrefix[rightChild]
        );

        maxPrefix[node] = Math.max(
                maxPrefix[leftChild],
                totalSum[leftChild] + maxPrefix[rightChild]
        );
    }

    /*
        Point update:
        Set index 'idx' to value 'val'.

        Iterative implementation:
        - Walk down to leaf
        - Store path
        - Pull upwards
    */
    void update(int idx, int val) {

        int node = 1;
        int left = 0, right = length - 1;

        int[] path = new int[32];   // stores path from root to leaf
        int pathSize = 0;

        // Go down to leaf
        while (left != right) {
            path[pathSize++] = node;

            int mid = left + (right - left) / 2;

            if (idx <= mid) {
                node = node * 2;
                right = mid;
            } else {
                node = node * 2 + 1;
                left = mid + 1;
            }
        }

        // Set leaf value
        totalSum[node] = val;
        minPrefix[node] = val;
        maxPrefix[node] = val;

        // Recompute upwards
        while (pathSize > 0) {
            pull(path[--pathSize]);
        }
    }

    /*
        Find rightmost index where prefix sum == target.

        We check:
        If target is outside global min/max prefix range → impossible.

        Then binary descend:
        Prefer right child first (to find rightmost).
    */
    int findRightmostPrefix(int target) {

        int node = 1;
        int left = 0, right = length - 1;
        int sumBefore = 0;

        // If target not possible at all
        if (target < minPrefix[node] || target > maxPrefix[node])
            return -1;

        while (left != right) {

            int mid = left + (right - left) / 2;

            int leftChild = node * 2;
            int rightChild = node * 2 + 1;

            int prefixSumIfGoRight = sumBefore + totalSum[leftChild];
            int neededInRight = target - prefixSumIfGoRight;

            /*
                If right subtree can contain needed prefix,
                go right to maximize index.
            */
            if (minPrefix[rightChild] <= neededInRight &&
                neededInRight <= maxPrefix[rightChild]) {

                node = rightChild;
                left = mid + 1;
                sumBefore = prefixSumIfGoRight;

            } else {
                node = leftChild;
                right = mid;
            }
        }

        return left;
    }
}

class Solution {

    public int longestBalanced(int[] nums) {

        int n = nums.length;

        /*
            We transform problem:

            - First distinct even occurrence → +1
            - First distinct odd occurrence  → -1

            Then:
            Balanced subarray = prefix sum == 0
        */
        SegmentTree segmentTree = new SegmentTree(n);

        /*
            firstOccurrence[value] = index of latest active occurrence
            If seen again, we cancel previous contribution.
        */
        int[] firstOccurrence = new int[100001];
        Arrays.fill(firstOccurrence, -1);

        int maxLength = 0;

        /*
            Traverse from right to left.

            Why?
            So we always treat current index as start,
            and ensure each number contributes only once.
        */
        for (int start = n - 1; start >= 0; --start) {

            int value = nums[start];

            // If value appeared later, remove its old contribution
            if (firstOccurrence[value] != -1) {
                segmentTree.update(firstOccurrence[value], 0);
            }

            firstOccurrence[value] = start;

            // Add new contribution:
            // even → +1
            // odd  → -1
            int contribution = (value & 1) == 0 ? 1 : -1;
            segmentTree.update(start, contribution);

            /*
                Find rightmost index where prefix sum = 0.
                That means:
                (#distinct even == #distinct odd)
            */
            int end = segmentTree.findRightmostPrefix(0);

            if (end >= start) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return maxLength;
    }
}
