public class Solution {
    private final long N = 100005;
    private final long hell = 1000000007;
    private long[] a = new long[(int) N];
    private long[] seg = new long[4 * (int) N];
    private long[] segsq = new long[4 * (int) N];
    private long[] lazy = new long[4 * (int) N];

    // Build the segment tree.
    private void build(int node, long start, long end) {
        if (start == end) {
            seg[node] = a[(int) start];
            segsq[node] = (a[(int) start] * a[(int) start]) % hell;
            return;
        }
        long mid = (start + end) >> 1;
        build(node << 1, start, mid);
        build(node << 1 | 1, mid + 1, end);
        seg[node] = (seg[node << 1] + seg[node << 1 | 1]) % hell;
        segsq[node] = (segsq[node << 1] + segsq[node << 1 | 1]) % hell;
    }

    // Update the segment tree and handle lazy propagation.
    private void update(int node, long start, long end, int l, int r, int val) {
        if (lazy[node] != 0) {
            segsq[node] += ((end - start + 1) * (lazy[node] * lazy[node]) % hell) % hell
                    + (2 * lazy[node] * seg[node]) % hell;
            segsq[node] %= hell;
            seg[node] += ((end - start + 1) * lazy[node]) % hell;
            seg[node] %= hell;
            if (start != end) {
                lazy[node << 1] += lazy[node];
                lazy[node << 1 | 1] += lazy[node];
            }
            lazy[node] = 0;
        }
        if (start > end || start > r || end < l)
            return;
        if (l <= start && end <= r) {
            segsq[node] += ((end - start + 1) * (val * val) % hell) % hell + (2 * val * seg[node]) % hell;
            segsq[node] %= hell;
            seg[node] += ((end - start + 1) * val) % hell;
            seg[node] %= hell;
            if (start != end) {
                lazy[node << 1] += val;
                lazy[node << 1 | 1] += val;
            }
            return;
        }
        long mid = (start + end) >> 1;
        update(node << 1, start, mid, l, r, val);
        update(node << 1 | 1, mid + 1, end, l, r, val);
        seg[node] = (seg[node << 1] + seg[node << 1 | 1]) % hell;
        segsq[node] = (segsq[node << 1] + segsq[node << 1 | 1]) % hell;
    }

    // Main function to find the sum of counts.
    public int sumCounts(int[] nums) {
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            a[i] = 0;
        }

        // Build the segment tree.
        build(1, 1, n);

        HashMap<Integer, Integer> prev_seen_at = new HashMap<>();

        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (!prev_seen_at.containsKey(nums[i])) {
                update(1, 1, n, i + 1, n, 1);
            } else {
                update(1, 1, n, i + 1, prev_seen_at.get(nums[i]) - 1, 1);
            }

            prev_seen_at.put(nums[i], i + 1);

            ans = (ans + segsq[1]) % hell;
        }

        return (int) ans;
    }
}