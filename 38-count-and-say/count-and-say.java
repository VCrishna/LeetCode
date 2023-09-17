class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 0; i < n - 1; i++) {
            // first character of newly formed result string
            char ch = result.charAt(0);
            // as 1 character is used or first character is used so count is 1
            int count = 1;
            StringBuilder sb = new StringBuilder();
            // from start to the end of result string
            for (int j = 1; j < result.length(); j++) {
                // if the current string is not equal to the character at current index 
                // then we append the count and character to our sb variable and
                // assign it with new character and count to 0 and continue until the end of string
                if (ch != result.charAt(j)) {
                    sb.append(count);
                    sb.append(ch);
                    ch = result.charAt(j);
                    count = 0;
                }
                // counting the characters
                count++;
            }
            // appending last character and its count
            sb.append(count);
            sb.append(ch);
            // updating the result with newly created string
            result = sb.toString();
        }
        return result;
    }
}
