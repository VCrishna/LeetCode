class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Creating a 2D array to combine position and speed of each car
        int[][] combined = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            combined[i][0] = position[i];
            combined[i][1] = speed[i];
        }

        // Sorting the combined array based on the position of the cars
        Arrays.sort(combined, (a, b) -> a[0] - b[0]);

        // Creating a stack to track arrival times of cars
        Stack<Double> stack = new Stack<>();

        // Iterating through the sorted combined array in reverse order
        for (int i = combined.length - 1; i >= 0; i--) {
            // time = distance ÷ speed
            // Calculating the time for the current car to reach the target
            double currentTime = (double) (target - combined[i][0]) / combined[i][1];

            // Checking if the stack is not empty and 
            // the current car arrives sooner than the car at the top of the stack
            if (!stack.isEmpty() && currentTime <= stack.peek()) {
                // If yes, continue to the next iteration without updating the stack
                continue;
            } else {
                // If no, push the current arrival time onto the stack
                stack.push(currentTime);
            }
        }

        // Returning the size of the stack, which represents the number of fleets
        return stack.size();
    }
}
