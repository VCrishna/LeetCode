class Solution {

    class Pair {
        int a;
        int b;
        int sum;
        int index2; // this will keep track of the index from nums2

        Pair(int i, int j, int index2) {
            this.a = i;
            this.b = j;
            this.sum = i + j;
            this.index2 = index2;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // Edge case
        if (nums1.length == 0 || nums2.length == 0 || k == 0) 
            return result;

        PriorityQueue<Pair> heap = new PriorityQueue<>((i, j) -> i.sum - j.sum);

        // Initially, populate the queue with elements paired with the first element of nums2
        // because it is the smallest element in nums2
        // also we do not need all the elements in nums1 we only need elements less than k
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heap.add(new Pair(nums1[i], nums2[0], 0));
        }

        while (k > 0 && !heap.isEmpty()) {
            Pair p = heap.poll();
            List<Integer> list = new ArrayList<>();
            list.add(p.a);
            list.add(p.b);
            result.add(list);

            // Adding next smallest element of nums2 into heap
            // as next smallest element can be formed with next element of nums2 as it is in sorted order
            if (p.index2 + 1 < nums2.length) {
                heap.add(new Pair(p.a, nums2[p.index2 + 1], p.index2 + 1));
            }
            k--;
        }

        return result;
    }
}
