class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int num2 = stack.pop();
            int num1 = stack.pop();
            int sol = 0;
            switch (token) {
                case "+":
                    sol = num1 + num2;
                    break;
                case "-":
                    sol = num1 - num2;
                    break;
                case "*":
                    sol = num1 * num2;
                    break;
                case "/":
                    sol = num1 / num2;
                    break;
            }
            stack.push(sol);
        }
        return stack.pop();
    }
}