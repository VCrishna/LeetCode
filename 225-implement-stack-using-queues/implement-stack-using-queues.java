class MyStack {
    List<Integer> stack;
    int count;

    public MyStack() {
        stack = new ArrayList<>();
        count = -1;
    }

    public void push(int x) {
        stack.add(x);
        count++;
    }

    public int pop() {
        if (count >= 0) {
            int last = stack.get(stack.size() - 1);;
            int index = stack.lastIndexOf(Integer.valueOf(last));
            stack.remove(index);
            count--;
            return last;
        }
        else{
            return 0;
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
