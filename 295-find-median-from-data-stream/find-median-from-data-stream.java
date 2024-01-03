class MedianFinder {
    // min heap to store the larger half of the numbers
    PriorityQueue<Integer> minHeap;
    // max heap to store the smaller half of the numbers
    PriorityQueue<Integer> maxHeap;
    // size is used to keep track of the total number of elements added
    int size;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        size = 0;
    }

    public void addNum(int num) {
        // adding num to maxHeap
        maxHeap.offer(num);
        // Transfering the maximum element from maxHeap to minHeap
        minHeap.offer(maxHeap.poll());
        // Balancing the sizes of maxHeap and minHeap
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        size++;
    }

    public double findMedian() {
        if (size % 2 == 0) {
            // Calculating the average for even-sized total elements
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // Returning the top element for odd-sized total elements
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */