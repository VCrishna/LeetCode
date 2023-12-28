class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            int number2 = stack.pop();
            int number1 = stack.pop();

            int result = 0;

            switch (token) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
            }

            stack.push(result);
        }

        return stack.pop();
    }

    public int evalRPN_BRUTE_FORCE(String[] tokens) {
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
