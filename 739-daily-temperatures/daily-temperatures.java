class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int currentDay = 0; currentDay < temperatures.length; currentDay++) {
            while (!stack.isEmpty() && temperatures[currentDay] > temperatures[stack.peek()]) {
                int previousDay = stack.pop();
                result[previousDay] = currentDay - previousDay;
            }
            stack.push(currentDay);
        }

        return result;
    }
}
