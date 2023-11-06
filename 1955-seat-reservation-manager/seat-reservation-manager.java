class SeatManager {
    PriorityQueue<Integer> minHeap;
    int count;

    public SeatManager(int n) {
        minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
        count = 1;
    }

    public int reserve() {
        if(minHeap.isEmpty())
            return count++;
        return minHeap.poll();
    }

    public void unreserve(int seatNumber) {
        minHeap.offer(seatNumber);
    }
}
/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
