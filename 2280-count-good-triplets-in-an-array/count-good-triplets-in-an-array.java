// Fenwick Tree (Binary Indexed Tree) to perform efficient prefix sum and updates
class FenwickTree {

    private int[] tree;

    public FenwickTree(int size) {
        // Initialize the tree array with size + 1 (1-based indexing)
        tree = new int[size + 1];
    }

    // Increment the value at position 'index' by 'delta'
    public void update(int index, int delta) {
        index++;  // Convert to 1-based indexing
        while (index < tree.length) {
            tree[index] += delta;         // Add delta to current node
            index += index & -index;      // Move to next responsible index
        }
    }

    // Compute the prefix sum from 0 to index
    public int query(int index) {
        index++;  // Convert to 1-based indexing
        int res = 0;
        while (index > 0) {
            res += tree[index];          // Accumulate current value
            index -= index & -index;     // Move to parent node
        }
        return res;
    }
}

class Solution {

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // pos2[i] = index of value i in nums2
        int[] pos2 = new int[n];
        // reversedIndexMapping[i] = index in nums1 of value that is at position i in nums2
        int[] reversedIndexMapping = new int[n];

        // Build mapping from value -> index in nums2
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        // Build transformed array: for each value in nums1, get its index in nums2,
        // then map it to its position in nums1
        for (int i = 0; i < n; i++) {
            reversedIndexMapping[pos2[nums1[i]]] = i;
        }

        // Fenwick Tree to count number of elements to the left of a given position
        FenwickTree tree = new FenwickTree(n);
        long res = 0;

        // Iterate through all values (since nums1 and nums2 are permutations of 0..n-1)
        for (int value = 0; value < n; value++) {
            int pos = reversedIndexMapping[value];  // Get transformed position in nums1

            // Count of elements to the left of 'pos' that we've already processed
            int left = tree.query(pos);

            // Mark this position as processed
            tree.update(pos, 1);

            // Number of elements to the right of pos = (n - 1 - pos)
            // Number of values already processed that are greater than current = value - left
            // So subtract that from right to get count of valid right-side elements
            int right = (n - 1 - pos) - (value - left);

            // For each element: total number of valid triplets it can form = left * right
            res += (long) left * right;
        }

        return res;
    }
}
