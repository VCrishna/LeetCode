import java.math.BigInteger;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        //Making the priority queue using custom comparator
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length()
        );

        for (String n : nums) {
            pq.add(n);
            //Deleting the kth largest everytime, so that pq contains only the largest k elements
            if (pq.size() > k) 
                pq.poll();
        }

        //Returning the minimum element in pq
        return pq.poll();
    }

    public String kthLargestNumber_BIGINTEGER(String[] nums, int k) {

        PriorityQueue<BigInteger> maxHeap = new PriorityQueue<>(
            (a, b) -> b.compareTo(a)
        );

        for (String s : nums) {
            maxHeap.add(new BigInteger(s));
        }

        for (int i = 0; i < k - 1; i++) maxHeap.remove();

        return maxHeap.peek().toString();
    }
}
