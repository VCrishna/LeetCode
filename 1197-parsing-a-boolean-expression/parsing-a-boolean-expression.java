class Solution {
    public boolean parseBoolExpr(String expression) {
        // Base case: If the expression starts with 't', return true
        if (expression.charAt(0) == 't') {
            return true;
        }
        // Base case: If the expression starts with 'f', return false
        if (expression.charAt(0) == 'f') {
            return false;
        }
        // If it's a NOT operator, negate the result of the sub-expression
        if (expression.charAt(0) == '!') {
            // Recursively evaluate the expression inside the NOT and return the negation
            return !parseBoolExpr(expression.substring(2, expression.length() - 1));
        }
        // If the operator is either AND ('&') or OR ('|'),
        // evaluate the list of sub-expressions
        return parseList(expression.substring(2, expression.length() - 1), expression.charAt(0) == '|');
    }

    // Helper function to handle lists of expressions for AND and OR
    private boolean parseList(String expression, boolean isOrOperator) {
        int parenParity = 0; // Keeps track of parentheses
        int prevIdx = 0; // Marks the beginning of each sub-expression
        int idx = 0;

        // Iterate through the expression to evaluate sub-expressions
        while (idx < expression.length()) {
            if (expression.charAt(idx) == '(') {
                parenParity++; // Open parenthesis encountered
            } else if (expression.charAt(idx) == ')') {
                parenParity--; // Close parenthesis encountered
            } else if (expression.charAt(idx) == ',' && parenParity == 0) {
                // Comma found at the same level (not inside parentheses), evaluate the
                // sub-expression
                if (parseBoolExpr(expression.substring(prevIdx, idx)) == isOrOperator) {
                    // Short-circuiting: For OR, if any sub-expression is true, return true
                    // For AND, if any sub-expression is false, return false
                    return isOrOperator;
                }
                prevIdx = idx + 1; // Move to the next sub-expression
            }
            idx++;
        }

        // Evaluate the last sub-expression in the list
        if (parseBoolExpr(expression.substring(prevIdx, idx)) == isOrOperator) {
            return isOrOperator;
        }

        // If we get here, return the opposite of the operator
        return !isOrOperator;
    }
}
