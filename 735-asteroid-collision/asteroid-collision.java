class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < asteroids.length) {
            if (asteroids[index] > 0) {
                stack.push(asteroids[index]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[index])) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[index]);
                } else if (!stack.isEmpty() && stack.peek() == Math.abs(asteroids[index])) {
                    stack.pop();
                }
            }
            index++;
        }
        int[] result = new int[stack.size()];
        int i = stack.size() - 1;
        while (i >= 0) {
            result[i--] = stack.pop();
        }
        return result;
    }
}
