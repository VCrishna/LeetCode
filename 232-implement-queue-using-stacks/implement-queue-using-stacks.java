class MyQueue {

    int count=-1;
    List<Integer> lst;

    public MyQueue() {
        lst=new ArrayList<>();
        
    }
    
    public void push(int x) {
        lst.add(x);
        count++;
        
    }
    
    public int pop() {
        int i=lst.get(0);
        lst.remove(Integer.valueOf(i));
        count--;
        return i;
    }
    
    public int peek() {
        if(count>=0)
            return lst.get(0);
        else
            return 0;
    }
    
    public boolean empty() {
        return lst.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */