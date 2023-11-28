import java.math.BigInteger;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> maxHeap = new PriorityQueue<>(
            (a, b) -> b.compareTo(a)
        );

        for(String s : nums) {
            maxHeap.add(new BigInteger(s));
        }
        
        for(int i = 0; i < k - 1; i++)
            maxHeap.remove();
        
        return maxHeap.peek().toString();
    }
}