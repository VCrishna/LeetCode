class MyCircularQueue {

    int[] queue;
    int size;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.size = k;
        this.front = -1;
        this.rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            front = 0;
            rear++;
            queue[rear] = value;
            return true;
        } else {
            if (rear + 1 == size) {
                rear = 0;
            } else {
                rear++;
            }
            queue[rear] = value;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            int res = queue[front];
            queue[front] = 0;
            if (front == rear) {
                front = rear = -1;
            } else if (front + 1 == size) {
                front = 0;
            } else {
                front++;
            }
            return true;
        }
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        if (rear + 1 == front) {
            return true;
        } else if (front == 0 && rear + 1 == size) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */