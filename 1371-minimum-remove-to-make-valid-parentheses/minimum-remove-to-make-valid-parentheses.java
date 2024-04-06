class Solution {
    public String minRemoveToMakeValid(String s) {
        // List to store characters from the input string
        List<Character> lst = new ArrayList<>();
        // List to store filtered characters (valid parentheses)
        List<Character> filtered = new ArrayList<>();
        // Counter to track the number of open parentheses
        int count = 0;
        
        // Iterating through each character in the input string
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If the character is an open parenthesis '(',
                // add it to the list and increment the counter
                lst.add(c);
                count++;
            } else if (c == ')' && count > 0) {
                // If the character is a closing parenthesis ')' 
                // and there are open parentheses to match,
                // add it to the list and decrement the counter
                lst.add(c);
                count--;
            } else if (c != ')') {
                // If the character is not a closing parenthesis ')',
                // add it to the list
                lst.add(c);
            }
        }
        
        // Reversely iterating through the list to filter out unmatched open parentheses
        for (int i = lst.size() - 1; i >= 0; i--) {
            if (lst.get(i) == '(' && count > 0) {
                // If the character is an unmatched open parenthesis 
                // and there are unmatched open parentheses remaining,
                // decrement the counter
                count--;
            } else {
                // Otherwise, add the character to the filtered list
                filtered.add(lst.get(i));
            }
        }
        
        // Constructing the result string by reversing the filtered list
        StringBuilder result = new StringBuilder();
        for (char c : filtered)
            result.append(c);
        
        // Returning the reversed result string
        return result.reverse().toString();
    }
}
