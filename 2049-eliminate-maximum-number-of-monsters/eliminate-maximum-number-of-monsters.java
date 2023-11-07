class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> arrivalHeap = new PriorityQueue<Double>();
        int count = 0;

        for (int i = 0; i < dist.length; i++) {
            arrivalHeap.offer((double) dist[i] / speed[i]);
        }
        while(!arrivalHeap.isEmpty()) {
            if(arrivalHeap.remove() <= count) 
                break;
            count++;
        }
        return count;
    }
}
