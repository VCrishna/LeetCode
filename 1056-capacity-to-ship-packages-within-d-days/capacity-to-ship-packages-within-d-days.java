class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        for (int i : weights) {
            left = Math.max(left, i);
            right += i;
        }
        while (left <= right) {
            int capacity = left + (right - left) / 2;
            if (canShip(weights, days, capacity)) {
                result = Math.min(result, capacity);
                right = capacity - 1;
            } else {
                left = capacity + 1;
            }
        }
        return result;
    }

    public boolean canShip(int[] weights, int days, int capacity) {
        int ships = 1;
        int currentCapacity = capacity;
        for (int w : weights) {
            if (currentCapacity - w < 0) {
                ships += 1;
                currentCapacity = capacity;
            }
            currentCapacity -= w;
        }
        return ships <= days;
    }
}