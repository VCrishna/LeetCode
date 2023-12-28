class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                int num1 = stack.isEmpty() ? 0 : stack.pop();
                int num2 = stack.isEmpty() ? 0 : stack.pop();
                stack.push(num1 + num2);
            } else if (s.equals("-")) {
                int num1 = stack.isEmpty() ? 0 : stack.pop();
                int num2 = stack.isEmpty() ? 0 : stack.pop();
                stack.push(num2 - num1);
            } else if (s.equals("*")) {
                int num1 = stack.isEmpty() ? 0 : stack.pop();
                int num2 = stack.isEmpty() ? 0 : stack.pop();
                stack.push(num1 * num2);
            } else if (s.equals("/")) {
                int num1 = stack.isEmpty() ? 0 : stack.pop();
                int num2 = stack.isEmpty() ? 0 : stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
