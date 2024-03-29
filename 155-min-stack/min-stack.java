class MinStack {
    // stack holds all the values
    Stack<Integer> stack;
    // minStack hold the current min value at the node or value in stack
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);
        int minVal = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(minVal);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */