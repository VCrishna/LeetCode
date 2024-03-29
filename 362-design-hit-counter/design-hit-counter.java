class HitCounter {
    Queue<Integer> queue;
    public HitCounter() {
        queue = new ArrayDeque<>();
    }
    
    public void hit(int timestamp) {
        queue.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!queue.isEmpty()) {
            if(timestamp - queue.peek() >= 300) {
                queue.remove();
            }
            else
                break;
        }
        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */