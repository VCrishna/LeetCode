class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        // we cannot process if the length of the given string 
        // is greater than 12
        if(s.length() > 12) {
            return result;
        }
        // backtrack(currentIndex, dots, currentIP, result)
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    public static void backtrack(
            String s,
            int currentIndex,
            int dots,
            StringBuilder currentIP,
            List<String> result) {
        // Base case: If we have formed a valid IP address with 4 segments and
        // consumed the entire string, add it to the result
        if (dots == 4 && currentIndex == s.length()) {
            result.add(currentIP.toString().substring(0, currentIP.length() - 1));
            return;
        }
        // Base case: If we have more than 4 segments or
        // if we have reached the end of the string, return
        if (dots > 4 || currentIndex >= s.length()) {
            return;
        }
        // Iterating over the string to form each segment of the IP address
        for (int i = currentIndex; i < Math.min(currentIndex + 3, s.length()); i++) {
            
            // Extracting the segment from the current index to 'i'
            String segment = s.substring(currentIndex, i + 1);
            
            // Avoid segments starting with '0' if they are not '0' themselves 
            // or greater than 255
            if (segment.length() > 1 && segment.startsWith("0") || Integer.parseInt(segment) > 255)
                break; // Moving to the next segment
            
            // Saving the length of current IP
            int len = currentIP.length();

            // Appending the segment and '.' to the current IP address
            currentIP.append(segment).append(".");
            // Recursively call backtrack to form the next segment
            backtrack(s, i + 1, dots + 1, currentIP, result);
            // Backtrack: Remove the last segment to explore other possibilities
            currentIP.setLength(len);// cleaning- backtrack: remove the last segment
        }

    }
}