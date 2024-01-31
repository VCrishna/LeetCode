class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Initializing the result array to store the
        // number of days until a warmer day for each temperature
        int[] result = new int[temperatures.length];

        // Creating a stack to track indices of temperatures
        // for which a warmer day is not found yet
        Stack<Integer> stack = new Stack<>();

        // Iterating through each day's temperature
        for (int currentDay = 0; currentDay < temperatures.length; currentDay++) {
            // While the stack is not empty and
            // the current temperature is higher than the temperature at the top of the
            // stack
            while (!stack.isEmpty() && temperatures[currentDay] > temperatures[stack.peek()]) {
                // Updating the result array for the temperature at the top of the stack
                int previousDay = stack.pop();
                result[previousDay] = currentDay - previousDay;
            }

            // Pushing the current day onto the stack
            stack.push(currentDay);
        }

        // Returning the result array containing
        // the number of days until a warmer day for each temperature
        return result;
    }
}
