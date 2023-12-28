class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        BACKTRACK(result, "", 0, 0, n);
        return result;
    }

    public void BACKTRACK(List<String> result, String currentString, int openCount, int closeCount, int max) {
        if (currentString.length() == max * 2) {
            result.add(currentString);
            return;
        }
        if (openCount < max) BACKTRACK(result, currentString + "(", openCount + 1, closeCount, max);
        if (closeCount < openCount) BACKTRACK(result, currentString + ")", openCount, closeCount + 1, max);
    }

    List<String> result = new ArrayList<String>();

    Stack<String> stack = new Stack<>();

    public List<String> generateParenthesis_STACK(int n) {
        generate(0, 0, n);

        return result;
    }

    private void generate(int countOpen, int countClose, int freq) {
        // countOpen == countClose == freq means we have used up all the brackets and what we have
        // is a valid string and you can add that to result and return safely.
        if (countOpen == freq && countOpen == countClose && countClose == freq) {
            result.add(stack.toString().replace(",", "").replace(" ", "").replace("[", "").replace("]", ""));

            return;
        }

        // we can add as many opening  "(" as the freq, check that
        if (countOpen < freq) {
            stack.add("(");
            generate(countOpen + 1, countClose, freq);
            stack.pop(); // after every back - tracking you need to clean up the stack for fresh start
        }

        // we can add closing "(" only when we have an opening ")", check that
        if (countClose < countOpen) {
            stack.add(")");
            generate(countOpen, countClose + 1, freq);
            stack.pop(); // after every back - tracking you need to clean up the stack for fresh start
        }
    }
}
