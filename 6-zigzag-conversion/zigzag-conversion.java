class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row<numRows; row++){
            int increment = 2 * (numRows - 1);
            for(int i = row; i<s.length(); i += increment){
                sb.append(s.charAt(i));
                if(row > 0 && row < numRows - 1 && i + increment - 2 * row < s.length()){
                    sb.append(s.charAt(i + increment - 2 * row));
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}


/**

In the Zigzag pattern, characters alternate between downward and upward slanting rows. The `if` condition checks if the current row is not the first or last row, and if there is a character at the next position in the row. If both of these conditions are true, then the character at the next position is also appended to the `StringBuilder` object.

This is necessary to construct the Zigzag pattern correctly - when a character is added to the current row, we also need to check if there is a character that needs to be added in a later position on the same row.

So the condition checks whether the index of the additional character that needs to be added is still within the bounds of the input string "s". Here's how that works:

- `increment - 2 * row` gives the distance between the additional character and the last character added to the current row.
- Subtracting this distance from the current index `i` gives the index of the additional character that needs to be added to the current row.
- If this calculated index is less than `s.length()`, it means there is an additional character that needs to be added to the current row.

Essentially, this condition adds an additional character to the zigzag pattern for rows other than the first and last row, since these rows have only one character interval (i.e. `increment = numRows + numRows - 2`) and don't contain any additional characters.

*/