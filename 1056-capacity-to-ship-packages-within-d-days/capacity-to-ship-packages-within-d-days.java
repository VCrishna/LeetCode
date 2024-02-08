class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Initializing the left and right bounds for binary search
        int left = Integer.MIN_VALUE;
        int right = 0;
        // Initializing the result with the maximum possible value
        int result = Integer.MAX_VALUE;
        
        // Calculating the left and right bounds for binary search
        for (int i : weights) {
            left = Math.max(left, i); // Left bound is the maximum weight among the weights
            right += i; // Right bound is the sum of all weights
        }
        
        // Performing binary search
        while (left <= right) {
            // Calculating the midpoint capacity
            int capacity = left + (right - left) / 2;
            // Checking if the current capacity can ship all weights within 'days' days
            if (canShip(weights, days, capacity)) {
                // If yes, updat the result with the minimum capacity found so far
                result = Math.min(result, capacity);
                // Adjusting the right bound for further search
                right = capacity - 1;
            } else {
                // If no, adjust the left bound for further search
                left = capacity + 1;
            }
        }
        // Returning the minimum capacity required to ship all weights within 'days' days
        return result;
    }

    // Helper method to check if the weights can be shipped within 'days' days with given 'capacity'
    public boolean canShip(int[] weights, int days, int capacity) {
        // Initializing the number of ships required
        int ships = 1;
        // Initializing the current capacity of the ship
        int currentCapacity = capacity;
        
        // Iterating through the weights
        for (int w : weights) {
            // If adding the current weight exceeds the current capacity
            if (currentCapacity - w < 0) {
                // Increase the number of ships required
                ships += 1;
                // Reset the current capacity to the capacity of a new ship
                currentCapacity = capacity;
            }
            // Decrease the current capacity by the weight
            currentCapacity -= w;
        }
        // Checking if the number of ships required is less than or equal to 'days'
        return ships <= days;
    }
}