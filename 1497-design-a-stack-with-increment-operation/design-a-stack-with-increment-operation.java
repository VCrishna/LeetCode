class CustomStack {

    List<Integer> lst = null;  // This list will act as the stack.
    int mxSize;  // Stores the maximum size the stack can grow to.

    // Constructor to initialize the stack with a maximum size.
    public CustomStack(int maxSize) {
        mxSize = maxSize;  // Set the maximum size.
        lst = new ArrayList<>();  // Initialize the stack as an empty list.
    }

    // Method to add an element to the stack.
    public void push(int x) {
        if (lst.size() == mxSize) {  // If the stack has reached its maximum size, do nothing.
            return;
        } else {
            lst.add(x);  // Otherwise, add the element to the stack.
        }
    }

    // Method to remove the top element from the stack and return it.
    public int pop() {
        if (lst.size() == 0) {  // If the stack is empty, return -1 (no element to pop).
            return -1;
        } else {
            return lst.remove(lst.size() - 1);  // Remove and return the last element (top of the stack).
        }
    }

    // Method to increment the first k elements of the stack by val.
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, lst.size()); i++) {  // Iterate over the first k elements or the total number of elements, whichever is smaller.
            lst.set(i, lst.get(i) + val);  // Add 'val' to each of the first k elements.
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
